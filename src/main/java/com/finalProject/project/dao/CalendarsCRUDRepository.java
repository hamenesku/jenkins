package com.finalProject.project.dao;


import org.springframework.data.repository.CrudRepository;

import com.finalProject.project.entity.Calendar;

public interface CalendarsCRUDRepository extends CrudRepository<Calendar, Integer> {

}