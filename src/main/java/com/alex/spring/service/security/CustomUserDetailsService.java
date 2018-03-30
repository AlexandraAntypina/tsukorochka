package com.alex.spring.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.alex.spring.entity.User;
import com.alex.spring.entity.UserStatus;
import com.alex.spring.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userRepository.findByLogin(login);
		
		if(user==null){
			throw new UsernameNotFoundException("User do not exists");
		}
		
		return convert(user);
	}

	private UserDetails convert(User user) {
		
		boolean enabled = (user.getStatus() == UserStatus.ACTIVE);
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = (user.getStatus() != UserStatus.DISABLED) && (user.getStatus() != UserStatus.PERMANENT_BAN);
		
		return new org.springframework.security.core.userdetails.User(
				user.getLogin(), user.getEncryptedPWD(),
				enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
				AuthorityUtils.createAuthorityList(user.getRole().toString()));
	}

}
