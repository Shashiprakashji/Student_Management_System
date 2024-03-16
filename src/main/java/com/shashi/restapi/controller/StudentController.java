package com.shashi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.restapi.entity.Student;
import com.shashi.restapi.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository repo;
//	get all students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students= repo.findAll();
		return students;
	}
	
//	http://localhost:8080/students/2
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
		return student;
	}
//	http://localhost:8080/students/add
	@PostMapping("students/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repo.save(student);

}
//	http://localhost:8080/students/update/2
	@PutMapping("students/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
		student.setName("John");
		student.setPercentage(67);
		repo.save(student);
		return student;
	}
	
	@DeleteMapping("students/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
		repo.delete(student);
	}
	
}
