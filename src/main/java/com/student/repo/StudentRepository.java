package com.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("select s from student s where s.name like %:c1% and s.name like %:c2% and s.name like %:c3%")
	List<Student> findByMatch(Character c1, Character c2, Character c3);
}
