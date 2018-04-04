package com.alex.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.spring.entity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long>{

}
