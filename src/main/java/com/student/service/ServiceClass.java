package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repo.StudentRepository;

@Service
public class ServiceClass {

	@Autowired
	StudentRepository repo;
	
	@Autowired
	Student student;
	
	public List<Student> getAllStudent() {
		return repo.findAll();
	}
	
	public Student getStudentById(int id) {
		Optional<Student> s = repo.findById(id);
		if(s.isEmpty()) {
			return student;
		}
		return s.get();
	}
	
	public List<Student> getStudentByName(String name) {
		List<Student> result = repo.findByMatch(name.charAt(0), name.charAt(1), name.charAt(2));
		return result;
	}
	
	public Student saveData(Student s) {
		repo.save(s);
		Optional<Student> s1 = repo.findById(s.getId());
		return s1.get();
	}
	
	public void deleteData(int id) {
		repo.deleteById(id);
	}
	
	public void updateData(int id, Student student) {
		Student s = repo.findById(id).get();
		if(student.getAge() != 0) {
			s.setAge(student.getAge());
		}
		if(student.getName() != null) {
			s.setName(student.getName());
		}
		if(student.getEmail() != null) {
			s.setEmail(student.getEmail());
		}
		if(student.getDob() != null) {
			s.setDob(student.getDob());
		}
		if(student.getMob() != 0) {
			s.setMob(student.getMob());
		}
		repo.save(s);
	}
}
