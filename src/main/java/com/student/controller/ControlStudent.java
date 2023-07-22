package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.repo.StudentRepository;
import com.student.service.ServiceClass;

@RestController
public class ControlStudent {

	@Autowired
	ServiceClass serviceClass;
	
	@GetMapping("/getstudent")
	ResponseEntity<List<Student>> getData() {
		return ResponseEntity.status(200).body(serviceClass.getAllStudent());
	}
	
	@GetMapping("/getstudent/{sid}")
	Student getStudent(@PathVariable("sid") int id) {
		return serviceClass.getStudentById(id);
	}
	
	@PostMapping("/savestudent")
	@ResponseBody
	Student saveData(@RequestBody Student s) {
		return serviceClass.saveData(s);
	}
	
	@DeleteMapping("/deletestudent/{id}")
	Student deleteStudent(@PathVariable("id") int id) {
		Student s = serviceClass.getStudentById(id);
		serviceClass.deleteData(id);
		return s;
	}
	
	@PutMapping("/updatestudent/{id}")
	Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
		System.out.println(student);
		serviceClass.updateData(id, student);
		return getStudent(id);
	}
	
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/getstudents/{keyword}")
	ResponseEntity<List<Student>> getStudentByKey(@PathVariable("keyword") String keyword) {
		return ResponseEntity.status(200).body(serviceClass.getStudentByName(keyword));
	}
}
