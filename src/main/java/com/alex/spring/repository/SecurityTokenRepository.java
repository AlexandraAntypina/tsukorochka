package com.alex.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.spring.entity.SecurityLoginToken;

@Repository
@Transactional
public interface SecurityTokenRepository extends JpaRepository<SecurityLoginToken, String> {

	SecurityLoginToken getBySeries(String series);

	long removeByLogin(String login);

}
