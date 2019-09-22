package com.wp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Emp {
	
	@Id
	private int eno;
	
	@NotBlank(message = "Please fill name field")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name can have only spaces and letters")
	@Size(min=2,max=20, message="Your Name Is Invalid , Please Use 2-20 Chars only")
	private String ename;
		
	@NotBlank(message = "Please fill email field")
	@Size(max = 20, min = 10, message = "Email size must be between 10 and 20")
	@Email(message = "Invalid email id")
	private String email;

	@Max(value = 10000000, message = "Maximum salary can be 1cr only")
	@Min(value = 10000, message = "Minimum salary can be 10000")
	private int sal;
		
	public Emp() {
		super();
	}

	public Emp(int eno, String ename, String email,  int sal) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.email = email;
		this.sal = sal;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Emp [eno=" + eno + ", ename=" + ename + ", email=" + email +" sal=" + sal + "]";
	}
	
	
	
}
