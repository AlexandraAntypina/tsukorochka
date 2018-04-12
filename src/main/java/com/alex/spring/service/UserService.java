package com.alex.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alex.spring.entity.User;
import com.alex.spring.entity.UserDetails;
import com.alex.spring.entity.UserRole;
import com.alex.spring.entity.UserStatus;
import com.alex.spring.repository.UserDetailsRepository;
import com.alex.spring.repository.UserRepository;
import com.alex.spring.service.cloud.CloudStorage;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CloudStorage cloudStorage;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	public String addUser( String phoneNumber,String login, 
						String email, String password){
		
		User user = new User();
		user.setLogin(login);
		user.setEmail(email);
		user.setEncryptedPWD(passwordEncoder.encode(password));
		user.setRole(UserRole.USER);
		user.setStatus(UserStatus.ACTIVATION_PENDING);
		
		UserDetails userDetails = new UserDetails();
		userDetails.setPhoneNumber(phoneNumber);
	
		
		user.setDetails(userDetails);
		
		userDetailsRepository.save(userDetails);
		userRepository.save(user);
		
		return createToken(email, login);
		
	}

	private String createToken(String email, String login) {
		String verificationData = createVerificationData(email,login);
		return passwordEncoder.encode(verificationData);
	}

	private String createVerificationData(String email, String login) {
		return email+login;
	}

	public boolean confirmEmail(String token, String login) {
		
		User user = userRepository.findByLogin(login);
		
		String email = user.getEmail();
		String verificationData = createVerificationData(email, login);
		
		if(	passwordEncoder.matches(verificationData, token)){
			user.setStatus(UserStatus.ACTIVE);
			userRepository.save(user);
			return true;
		}else{
			return false;
		}
		
	}

	public User findUserByLogin(String login) {
		
		return userRepository.findByLogin(login);
	}

	@Transactional
	public String addDataToProfile(String login, String name, String surname,
			String birthday, String email, String phoneNumber, String gender) {
		
		User user = userRepository.findByLogin(login);
		user.setEmail(email);
		
		UserDetails details = user.getDetails();
		details.setName(name);
		details.setSurname(surname);
		details.setBirthday(birthday);
		details.setPhoneNumber(phoneNumber);
		details.setGender(gender);
		
		userDetailsRepository.save(details);
		userRepository.save(user);
		
		return null;
	}

	@Transactional
	public void uploadAvatar(String login, MultipartFile file) {
		
		User user = userRepository.findByLogin(login);
		String url = cloudStorage.upload(file, "/users/"+login+"/photo", "avatar");
		if(url != null){
			user.setAvatarUrl(url);
			userRepository.save(user);
		}
	}

	public boolean addAdmin(String login, String email, String password) {
		
		if(userRepository.findByLogin(login) != null){
			return false;
		}
		
		User user = new User();
		user.setLogin(login);
		user.setEmail(email);
		user.setEncryptedPWD(passwordEncoder.encode(password));
		user.setRole(UserRole.SUPER);
		user.setStatus(UserStatus.ACTIVE);
		
		userRepository.save(user);
		
		return true;
	}
	
}
