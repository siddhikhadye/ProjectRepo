package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.Table;


@Entity
@Table(name="Employee_Det1" )
public class Employee {
	
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)

   @Column(name="Employee_id" ,nullable=true,unique=true)
   private int eid;
    
	@Column(name="Employee_name" ,nullable=true)
    private String ename;
	
	@Column(name="Employee_sal" ,nullable=true)
	private String esal;
	
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="dept_id",column=@Column(name="training_id")),	
		@AttributeOverride(name="dept_name",column=@Column(name="training_name"))	
		})
    Department traning;
	

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsal() {
		return esal;
	}
	public void setEsal(String esal) {
		this.esal = esal;
	}
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="dept_id",column=@Column(name="admin_id")),	
		@AttributeOverride(name="dept_name",column=@Column(name="admin_name"))	
		})
     Department admin;
	
	@ElementCollection

	@JoinTable(name="Dept_Details",
	joinColumns=@JoinColumn(name="deptId_FK"))
    private Set<Department> dept= new HashSet();
	
	

   public Set<Department> getDept() {
		return dept;
	}
	public void setDept(Set<Department> dept) {
		this.dept = dept;
	}
public Department getTraning() {
		return traning;
	}
	public void setTraning(Department training) {
		this.traning = training;
	}
	public Department getAdmin() {
		return admin;
	}
	public void setAdmin(Department admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", traning=" + traning + ", admin="
				+ admin + ", dept=" + dept + "]";
	}
	
	  
}
