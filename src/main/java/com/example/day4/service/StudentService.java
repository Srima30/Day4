package com.example.day4.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day4.model.StudentEntity;
import com.example.day4.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo sr;
	
	public StudentEntity saveinfo(StudentEntity ss) {
		return sr.save(ss);
	}
	public List<StudentEntity> savedetails(List<StudentEntity> ss){
		return (List<StudentEntity>)sr.saveAll(ss);
	}
	public List<StudentEntity> showinfo(){
		return sr.findAll();
	}
	public Optional<StudentEntity> showinfo(int id){
		return sr.findById(id);
	}
	//get by id
	public Optional<StudentEntity> showbyid(int id){
		return sr.findById(id);
	}
	public StudentEntity changeinfo(StudentEntity ss) {
		return sr.saveAndFlush(ss);
	}
	
	public String updateinfobyid(int id,StudentEntity ss) {
		sr.saveAndFlush(ss);
		if(sr.existsById(id)) {
			return "UPDATED";
		}
		else {
			return "Enter valid id";
		}
	}
	public void deleteinfo(StudentEntity ss) {
		sr.delete(ss);
	}
	//delete by id pathvariable
	public void deleteid(int id) {
		sr.deleteById(id);
	}
	//req par
	public void deletepid(int id) {
		sr.deleteById(id);
	}
	

}