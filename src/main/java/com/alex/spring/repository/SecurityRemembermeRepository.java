package com.alex.spring.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;

import com.alex.spring.entity.SecurityLoginToken;


@Repository
public class SecurityRemembermeRepository implements PersistentTokenRepository{

	@Autowired
	private SecurityTokenRepository tokenRepository;
	
	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		
		SecurityLoginToken loginToken = new SecurityLoginToken();
		loginToken.setLogin(token.getUsername());
		loginToken.setSeries(token.getSeries());
		loginToken.setToken(token.getTokenValue());
		loginToken.setLastUsed(token.getDate());
		
		tokenRepository.save(loginToken);
	}
	
	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		SecurityLoginToken loginToken = tokenRepository.getBySeries(seriesId);
		
		return new PersistentRememberMeToken(loginToken.getLogin(), loginToken.getSeries(),
				loginToken.getToken(), loginToken.getLastUsed());
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		SecurityLoginToken loginToken = tokenRepository.getBySeries(series);
		loginToken.setToken(tokenValue);
		loginToken.setLastUsed(lastUsed);
		tokenRepository.save(loginToken);
	}

	@Override
	public void removeUserTokens(String username) {
		tokenRepository.removeByLogin(username);		
	}



}
