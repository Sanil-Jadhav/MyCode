package com.sanil.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;



@Data
@Document(collection = "student")
@CompoundIndex(name = "primary_index", def = "{'id' : 1}")

public class Student implements Serializable 

{

	@Id
	@Field("student_id")
	private String id;
	
	@Field("name")
	private String name;
	
	@Field("surname")
	private String surname;
	
}
