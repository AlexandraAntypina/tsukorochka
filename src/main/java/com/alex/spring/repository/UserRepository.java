package com.alex.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.spring.entity.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByLogin(String login);
	
}
