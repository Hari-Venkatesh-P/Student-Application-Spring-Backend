package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired StudentService studentService; 
	
	@GetMapping("getstudent")
	public Optional<Student> getStudent(@RequestParam String id)
	{
		return studentService.getStudent(id);
	}
	
	@GetMapping("getallstudent")
	public List<Student> getAllStudent()
	{
		return studentService.getAllStudent();
	}
	
	@PostMapping("addstudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
		
	}
	
	@GetMapping("removestudent")
	public ResponseEntity<String> removeStudent(@RequestParam String id)
	{
		return studentService.removeStudent(id);
	}
	
	@GetMapping("updatestudent")
	public ResponseEntity<String> updateStudent(@RequestParam String id,@RequestParam String passkey)
	{
		return studentService.updateStudent(id,passkey);
	}
}
