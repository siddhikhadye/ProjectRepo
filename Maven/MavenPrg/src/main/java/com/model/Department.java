package com.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class Department {
	private int dept_id;
	private String dept_name;
	
	@Column(name="Department_id" ,nullable=false,unique=true)


	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	@Column(name="Department_name",length=30, nullable=true)

	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String d_name) {
		this.dept_name = d_name;
	}
	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + "]";
	}
	
	
	
}
