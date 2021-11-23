package com.concretepage.rest;
import java.util.Map;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

public class EmployeeController implements ModelDriven<Object>{

	private String id;
	private Object model;
	private static EmployeeRepository employeeRepository = new EmployeeRepository();
	
	private static Map<String,Employee>	map = employeeRepository.findAllEmployee();
	
/*	private EmployeeRepository employeeRepository = new EmployeeRepository();
	
	private static Map<String,Employee> map;
	{
		map = employeeRepository.findAllEmployee();
	}
 
 */
	
	public HttpHeaders index() {
		System.out.println("Index");
		model = map;
		return new DefaultHttpHeaders("index").disableCaching();
	}
	public String add(){
		System.out.println("add");
		Integer empId = Integer.parseInt(id);
		Employee emp = new Employee(empId,"Ramesh", "PQR");
		model = emp;
		return "SUCCESS";
	}
/*	public String getId() {
		System.out.println("getId");
		return id;
	}*/

	public void setId(String id) {
		System.out.println("setId");
		model = employeeRepository.getEmployeeById(id);
		this.id = id;
	}
	@Override
	public Object getModel() {
		System.out.println("getModel");
		return model;
	}
} 