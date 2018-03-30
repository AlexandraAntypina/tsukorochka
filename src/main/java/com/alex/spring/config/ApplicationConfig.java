package com.alex.spring.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.alex.spring.repository")
@ComponentScan(basePackages={
	"com.alex.spring.repository",
	"com.alex.spring.service",
	"com.alex.spring.mail"
})
@PropertySource({
	"classpath:database.properties",
	"classpath:mail.properties"
})
public class ApplicationConfig {
	
	@Bean("entityManagerFactory")
	public EntityManagerFactory  getEntityManagerFactory (@Autowired Environment env){
		Properties jpaProperties = new Properties();
		
		// loading JDBC properties
		jpaProperties.put(org.hibernate.cfg.Environment.DRIVER, env.getProperty("jdbc.driver"));
		jpaProperties.put(org.hibernate.cfg.Environment.URL, env.getProperty("jdbc.url"));
		jpaProperties.put(org.hibernate.cfg.Environment.USER, env.getProperty("jdbc.user"));
		jpaProperties.put(org.hibernate.cfg.Environment.PASS, env.getProperty("jdbc.password"));

		// loading hibernate specific properties
		jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.show_sql"));
		jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, env.getProperty("hibernate.dialect"));
		jpaProperties.put(org.hibernate.cfg.Environment.ENABLE_LAZY_LOAD_NO_TRANS, "true");
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPackagesToScan("com.alex.spring.entity");
		factory.setJpaProperties(jpaProperties);
		factory.setPersistenceUnitName("spring-jpa-unit");
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.afterPropertiesSet();
		
		return factory.getObject();

	}
	
	@Bean("transactionManager")
	public PlatformTransactionManager geTransactionManager(@Autowired EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	@Bean
	public JavaMailSender  getMailSender(@Autowired Environment env){
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl(); 
		
		mailSender.setHost(env.getProperty("email.host"));
		mailSender.setPort(Integer.valueOf(env.getProperty("email.port")));
		mailSender.setDefaultEncoding("UTF-8");
		mailSender.setUsername(env.getProperty("email.username"));
		mailSender.setPassword(env.getProperty("email.password"));

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", env.getProperty("email.transport.protocol"));
		props.put("mail.smtp.auth", env.getProperty("email.smtp.auth"));
		props.put("mail.smtp.starttls.enable", env.getProperty("email.smtp.starttls.enable"));
		props.put("mail.debug", env.getProperty("email.debug"));

		props.setProperty("mail.smtp.allow8bitmime", "true");
		props.setProperty("mail.smtps.allow8bitmime", "true");
		
		return mailSender;
	}

}
