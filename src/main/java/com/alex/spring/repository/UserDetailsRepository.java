package com.alex.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.spring.entity.UserDetails;

@Repository
@Transactional
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

}
