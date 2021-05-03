package com.sanil.controller;





import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sanil.model.Student;
import com.sanil.service.StudentService;



@RestController	
@RequestMapping("student")
public class StudentController {
	
	
	private static final Logger LOGGER = LogManager.getLogger(StudentController.class);
	

	@Autowired(required = true)
	StudentService studentService;
		
	
 

	@ResponseBody
	@RequestMapping(value ="/add",method = RequestMethod.POST,produces = { "application/json" })
	public String add(@RequestBody Student stud)
	{
		String response = "{\"message\":\"error\"}";
		
		
		try 
		{
			LOGGER.info("data = " + stud.toString() );
			
			studentService.add(stud);
			
			response = "{\"message\":\"success\"}";
			
		} 
		
		catch (Exception e) 
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = "{\"message\":\"error\"}";
		}
		return response;
		
	}
	
	@ResponseBody
	@RequestMapping(value ="/get/by/id",method = RequestMethod.POST,produces = { "application/json" })
	
	public String getById(@RequestBody Student stud)
	{
		String response = "{\"message\":\"error\"}";
		
		LOGGER.info("Student = " + 
				(new GsonBuilder().setPrettyPrinting().create())
					.toJson(stud, Student.class) );
		
		try 
		{
			LOGGER.info("data = " + stud.toString() );
			
           Optional<Student> optionalObj = studentService.getById(stud);
        	
        	
        	LOGGER.info("Student optionalObj.isPresent() = " + optionalObj.isPresent());
        	
    		Gson gson = new Gson();

        	
        	if (optionalObj.isPresent()) 
        	{
        		List<Student>  studentList = new ArrayList<Student>();
        		
        		studentList.add(optionalObj.get());
        		
        		LOGGER.info("Student list = " + studentList);
        		
            	Type listType = new TypeToken<List<Student>>(){}.getType();



            	response = "{\"message\":\"success\", "
            			+ "\"student_list\" : " + ( new GsonBuilder().create() ).toJson(studentList, listType) + ""
            			+ "}";
            
        	}
        	else 
        	{
    			response = "{\"message\":\"not_found\"}";

        	}
			
		} 
		
		catch (Exception e) 
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = "{\"message\":\"error\"}";
		}
		return response;
		
	}
	
	@ResponseBody
	@RequestMapping(value ="/update",method = RequestMethod.POST,produces = { "application/json" })
	public String update(@RequestBody Student stud)
	{
		String response = "{\"message\":\"error\"}";
		
		
		try 
		{
			LOGGER.info("data = " + stud.toString() );
			
			studentService.update(stud);
			
			response = "{\"message\":\"success\"}";
			
		} 
		
		catch (Exception e) 
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = "{\"message\":\"error\"}";
		}
		return response;
		
	}
			

}
