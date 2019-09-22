package com.wp.dao;

import java.util.List;
import com.wp.models.Emp;

public interface EmployeeDao {
	
	public Emp insertEmp(Emp e);
	public Emp updateEmp(Emp e);
	public Emp deleteEmp(int eno);
	public Emp getEmp(int eno);
	public List<Emp> searchEmp(String enoename);
	public List<Emp> getAllEmployees();
}
