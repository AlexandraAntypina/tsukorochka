package com.alex.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.spring.entity.AnonymousCalendar;

@Repository
public interface AnonymousCalendarRepository extends JpaRepository<AnonymousCalendar, Long>{

}
