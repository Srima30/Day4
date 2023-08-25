package com.example.day4.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4.model.StudentEntity;
import com.example.day4.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService sser;
	
	@PostMapping("addstudent")
	public StudentEntity add(@RequestBody StudentEntity ss) {
		return sser.saveinfo(ss);
	}
	@PostMapping("addnstudent")
	public List<StudentEntity> addndetails(@RequestBody List<StudentEntity> ss){
		return sser.savedetails(ss);
	}
	
	@GetMapping("showdetails")
	public List<StudentEntity> show(){
		return sser.showinfo();
		
	}
	//show by id
	@GetMapping("showdetbyid/{id}")
		public Optional<StudentEntity> showid(@PathVariable int id){
			return sser.showbyid(id);
		}
	
	@PutMapping("update")
	public StudentEntity modify(@RequestBody StudentEntity ss ) {
		return sser.changeinfo(ss);
	}
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id, @RequestBody StudentEntity ss) {
		return sser.updateinfobyid(id,ss);
	}
	@DeleteMapping("deletedetail")
		public String del(@RequestBody StudentEntity ss) {
			sser.deleteinfo(ss);
			return "Deleted successfully";
		}
	//pathvariable example
	@DeleteMapping("delid/{id}")
	public void deletemyid(@PathVariable int id) {
		sser.deleteid(id);
	}
	//req param example
	@DeleteMapping("delparamid")
	public void deletemyparamid (@RequestParam int id) {
		sser.deletepid(id);
	}
	}