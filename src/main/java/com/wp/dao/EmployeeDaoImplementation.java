package com.wp.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.models.Emp;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Emp insertEmp(Emp e) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(e);
		tr.commit();
		Emp newe = session.get(Emp.class, e.getEno());
		return newe;
	}

	@Override
	public Emp updateEmp(Emp e) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(e);
		tr.commit();
		Emp newe = session.get(Emp.class, e.getEno());
		return newe;
	}

	@Override
	public Emp deleteEmp(int eno) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Emp e = session.get(Emp.class, eno);
		session.delete(e);
		tr.commit();
		Emp newe = session.get(Emp.class, eno);//This is to verify delete newe should be null if deleted is successfully
		return newe;
	}

	@Override
	public Emp getEmp(int eno) {
		Session session = sessionFactory.openSession();
		Emp e = session.get(Emp.class, eno);
		return e;
	}
	
	@Override
	public List<Emp> getAllEmployees(){
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Emp.class);
		List<Emp> list = cr.list();
		return list;
	}
	
	@Override
	public List<Emp> searchEmp(String enoename){
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select eno,ename,email,sal from emp where eno like '%"+enoename+"%' or lower(ename) like lower('%"+enoename+"%') ");
//		Criteria cr = session.createCriteria(Emp.class);
//		Criterion empno = Restrictions.ilike("eno", e.getEno());
//		Criterion empname = Restrictions.like("ename", e.getEno());
//		LogicalExpression orExp = Restrictions.or(empno, empname);
//		cr.add(orExp);
		List<Object[]> list = query.list();
		List<Emp> emplist = new ArrayList<Emp>();
		for(int i=0; i<list.size();i++) {
			Emp e1 = new Emp(((BigDecimal) list.get(i)[0]).intValue(),(String) list.get(i)[1],(String) list.get(i)[2],((BigDecimal) list.get(i)[3]).intValue());
			emplist.add(e1);
		}
		return emplist;
	}
}
