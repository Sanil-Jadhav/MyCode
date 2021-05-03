package com.sanil.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sanil.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> 
{

	
	/*
	 * @Query(value = "{'name': {$regex : ?0, $options: 'i'}}") public List<Student>
	 * findByNameRegex(String regexString);
	 * 
	 * 
	 * @Query(value = "{'surname': {$regex : ?0, $options: 'i'}}") public
	 * List<Student> findBySurnameRegex(String regexString);
	 * 
	 * 
	 * @Query(value = "{'id': {$regex : ?0, $options: 'i'}}") public List<Student>
	 * findByIdRegex(String regexString);
	 * 
	 * public List<Student> findTop100ByOrderByCreateDateDesc();
	 * 
	 * 
	 * @Query(value = "{'create_date':{ $gte: ?0, $lte: ?1}}") public List<Student>
	 * findBetweenCreate_date(Date createDate, Date updateDate);
	 * 
	 * 
	 * 
	 * 
	 */
}