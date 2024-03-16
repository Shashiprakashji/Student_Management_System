package com.shashi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shashi.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
