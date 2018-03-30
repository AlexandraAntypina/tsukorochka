package com.alex.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.alex.spring.entity.UserRole;
import com.alex.spring.service.security.CustomRememberMeService;
import com.alex.spring.service.security.SecurityAuthSuccessHandler;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private static final String REMEMBER_ME_COOCKIES = "sugaring-tsukorochka-coockie";
	private static final String REMEMBER_ME_PARAM = "remember-me";
	private static final int REMEMBER_ME_PERIOD = 365*24*60*60;
	private static final String REMEMBER_ME_KEY = "remember-me-key";
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private PersistentTokenRepository tokenRepository;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
				.usernameParameter("login")
				.passwordParameter("password")
				.loginPage("/user/login")
				.loginProcessingUrl("/user/login")
				.successHandler(new SecurityAuthSuccessHandler())
				.failureUrl("/login-failed")
			.and()
			
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.deleteCookies("JSESSIONID", REMEMBER_ME_COOCKIES)
				.invalidateHttpSession(true)
			.and()
			
			.authorizeRequests()
				.antMatchers("/admin/**").hasRole(UserRole.SUPER.toString())
//				.antMatchers("/user/**").hasAnyRole(UserRole.SUPER.toString(),UserRole.USER.toString())
				.antMatchers("/user/login").permitAll()
				.anyRequest().permitAll()
			.and()
			
			.exceptionHandling()
				.accessDeniedPage("/access-denied")
			.and()
			
			.sessionManagement()
				.maximumSessions(1)
				.and()
			.and()
			
			.rememberMe()
				.rememberMeServices(rememberMeServices())
			.and()
			.csrf().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		for(String path : Globals.RESOURCES) {
			web.ignoring().antMatchers(path + "/**");
		}
	}
	
	@Bean(name = "pwdEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public RememberMeServices rememberMeServices() {
    	CustomRememberMeService rememberMeService = 
    			new CustomRememberMeService(REMEMBER_ME_KEY, userDetailsService, tokenRepository);
        
        rememberMeService.setCookieName(REMEMBER_ME_COOCKIES);
        rememberMeService.setParameter(REMEMBER_ME_PARAM);
        rememberMeService.setTokenValiditySeconds(REMEMBER_ME_PERIOD);
        
        return rememberMeService;
    }
}
