package com.wp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.models.Emp;
import com.wp.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
		
	@RequestMapping("entryform")
	public ModelAndView viewEntryForm(@ModelAttribute("Emp") Emp e) {
		ModelAndView mv = new ModelAndView("EntryForm");
		return mv;
	}
	
	//search employee by id or ename
	@RequestMapping("searchemp")
	public ModelAndView searchEmployee(@RequestParam("enoename") String enoename){
		List<Emp> emplist = employeeservice.searchEmp(enoename);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("EmpList",emplist);
		if(emplist.size()>0) 
		{
		mv.addObject("searchresult", true);
		}
		else {
			mv.addObject("searchresult", false);
		}
		return mv;
	}
	
	//insert an employee data in table
	@RequestMapping("entryemployee")
	public ModelAndView employeeEntry(@Valid @ModelAttribute("Emp") Emp emp, BindingResult result) {
		
		if(result.hasErrors()) {
			ModelAndView mv = new ModelAndView("EntryForm");
			return mv;
		}
		
		Emp e = employeeservice.save(emp);
		ModelAndView mv = new ModelAndView("EntryForm");
		if(e != null) {
			mv.addObject("Emp", e);
			mv.addObject("result", true);
		}
		else {
		mv.addObject("result",false);
		}
		return mv;
	}
	
	//provide employee list
	@RequestMapping("getallemployee")
	public ModelAndView allEmployee() {
		List<Emp> emplist = employeeservice.getAllEmployees();
		ModelAndView mv = new ModelAndView("EmployeeList");
		mv.addObject("EmpList",emplist);
		return mv;
	}
	
	//get employee details
	@RequestMapping("updatepage")
	public ModelAndView getUpdateEmp(@RequestParam("eno") int eno) {
		Emp e = employeeservice.get(eno);
		ModelAndView mv = new ModelAndView("UpdateEmp");
		mv.addObject("Emp", e);
		return mv;
	}
	
	//update employee data
	@RequestMapping("updateemp")
	public ModelAndView updateEmp(@Valid @ModelAttribute("Emp") Emp emp, BindingResult result) {
		
		if(result.hasErrors()) {
			ModelAndView mv = new ModelAndView("UpdateEmp");
			return mv;
		}
		Emp e = employeeservice.update(emp);
		ModelAndView mv = new ModelAndView("UpdateEmp");
			if(e != null) {
			mv.addObject("result",true);
			mv.addObject("Emp", e);
			}
			else {
			mv.addObject("result",false);
			}
		return mv;
	}
	
	//delete employee
	@RequestMapping("deleteemp")
	public ModelAndView deleteEmp(@RequestParam("eno") int eno) {
		Boolean result = employeeservice.delete(eno);
		ModelAndView mv = new ModelAndView("DeleteEmpResult");
		mv.addObject("Result", result);
		return mv;
	}
	
}
