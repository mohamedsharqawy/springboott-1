package com.SpringBootH2Integration.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootH2Integration.StudentRepository.StudentRepository;
import com.SpringBootH2Integration.StudentService.StudentService;
import com.SpringBootH2Integration.model.Student;

@RestController
@RequestMapping("/students")
public class studentController {
	
	@Autowired
	
	StudentService studentservice;
	
	 //@RequestMapping(value = "/students", method = RequestMethod.GET)
	 @GetMapping(value= "/students")
	
	public ArrayList<Student> getAllStudents(){
		return studentservice.getAllStudents();
		
	}
	
//	@RequestMapping(value = "/students", method = RequestMethod.GET)
	@GetMapping(value= "/students{id}")
	
	public Student getStudentById(int id) {
		
		return studentservice.getStudentByID(id);
	}
	
	@DeleteMapping("students/{id}")

	public void DeleteStudentById(int id) {
		 studentservice.DeleteById(id);
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public int AddNewStudent(@RequestBody Student student) {
		studentservice.SaveorUpdate(student);
		return student.getId();
	}
	

}
