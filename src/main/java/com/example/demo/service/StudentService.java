package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;


@Service
public class StudentService {

	@Autowired StudentRepo studentRepo;
	
	public Optional<Student> getStudent(String id)
	{
		return studentRepo.findById(id);
	}
	
	public List<Student> getAllStudent()
	{
		return studentRepo.findAll();
	}
	
	public ResponseEntity<String> addStudent(Student student)
	{
		if(studentRepo.existsById(student.getId()))
		{		
			return new ResponseEntity<String>("Error in creating the student",HttpStatus.BAD_REQUEST);
		}
		else
		{
			studentRepo.save(student);
			return new ResponseEntity<String>("Student Saved",HttpStatus.OK);
		}
		
	}
	
	public ResponseEntity<String> removeStudent(String id)
	{
		if(studentRepo.existsById(id))
		{	
			studentRepo.removeStudent(id);
			return new ResponseEntity<String>("Student removed",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in removing the student",HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> updateStudent(String id,String passkey)
	{
		if(studentRepo.existsById(id))
		{	
			studentRepo.updateStudent(id,passkey);
			return new ResponseEntity<String>("Student Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in updating the student",HttpStatus.BAD_REQUEST);
		}
	}
}
