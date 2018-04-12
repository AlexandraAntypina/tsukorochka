package com.alex.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.alex.spring.entity.User;
import com.alex.spring.entity.UserRole;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{
	
	User findByLogin(String login);

	List<User> findByRole(UserRole role);
	
}
