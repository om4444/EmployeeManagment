package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.repository.EmployeeRepository;

@RestController
public class DemoController {

	@Autowired
	EmployeeRepository er ;
	
	@PostMapping("/savedata")
	public void saveemployee(@RequestBody Employee e) {
		System.out.println(e.getAge());
		er.save(e);
	}
	
	@GetMapping("/getdata")
	public Employee getemployee(@RequestParam int id) {
		Optional<Employee> oe = er.findById(id);
		return oe.get();
	}
	@GetMapping("/alldata")
	public List<Employee> getallemployee(){
		List<Employee> le = er.findAll();
		return le;
	}
	@DeleteMapping("/deletedata")
	public String deleteemployeedata(@RequestParam int id) {
		er.deleteById(id);
		return "deleted sucessfully";
	}
	@PutMapping("/updatedata")
	public void updateemployeedata(@RequestBody Employee e) {
		er.save(e);
	}
}
