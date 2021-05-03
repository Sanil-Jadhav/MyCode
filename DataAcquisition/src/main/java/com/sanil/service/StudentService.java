package com.sanil.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanil.model.Student;
import com.sanil.repository.StudentRepository;



@Service
public class StudentService 
{
	private static final Logger LOGGER = LogManager.getLogger(StudentService.class);
	

	   @Autowired(required = true)
	  	StudentRepository studentRepository;
	 
	

	public void add(Student data) throws Exception
	{
		


    	LOGGER.info("Student add started ");
    	
    	studentRepository.save(data);
    	
    	
    	
		
	}
	public void update(Student data) throws Exception
	{
		


    	LOGGER.info("Student update started ");
		
    	studentRepository.save(data);
    	
    }
	public Optional<Student> getById(Student data) throws Exception
	{
		
		Optional<Student> optionalObj = studentRepository.findById(data.getId().toLowerCase());
		
		
		
		return optionalObj;
				
	}

}
