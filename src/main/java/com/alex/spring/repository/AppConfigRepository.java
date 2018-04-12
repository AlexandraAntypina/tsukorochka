package com.alex.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.spring.entity.AppConfig;

@Repository
public interface AppConfigRepository extends JpaRepository<AppConfig, Long> {

}
