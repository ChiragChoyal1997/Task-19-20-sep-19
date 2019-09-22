package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.dao.EmployeeDao;
import com.wp.dao.EmployeeDaoImplementation;
import com.wp.models.Emp;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	
	public void setEmpDao(EmployeeDaoImplementation empDao) {
		this.empDao = empDao;
	}

	public List<Emp> searchEmp(String enoename){
		List<Emp> emplist = empDao.searchEmp(enoename);
		return emplist;
	}
	public Emp save(Emp e) {
		Emp newe = empDao.insertEmp(e);
		return newe;
	}
	
	public Boolean delete(int eno) {
		Emp newe = empDao.deleteEmp(eno);
		if(newe == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Emp update(Emp e) {
		Emp newe = empDao.updateEmp(e);
		return newe;
	}
	
	public Emp get(int eno) {
		Emp newe = empDao.getEmp(eno);
		return newe;
	}
	
	public List<Emp> getAllEmployees(){
		List<Emp> emplist = empDao.getAllEmployees();
		return emplist;
	}
}
