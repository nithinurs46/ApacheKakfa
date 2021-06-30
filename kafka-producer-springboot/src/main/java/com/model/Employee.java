package com.model;

public class Employee {

	private String empId;
	private String empName;
	private String salary;
	
	public Employee() {
	}

	public Employee(String empId, String empName, String salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}
