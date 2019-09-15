package core;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employees")

public class Employees {
	
		@XmlElement(name = "employee")
		List<Employee> employee = new ArrayList<Employee>();
		List<Employee> getEmployees() {return employee;}
	
		public static class Employee {

		@XmlAttribute(name = "id")	
		List<String> id = new ArrayList<String>();
		List<String> getId() 			{return id;}
	
		@XmlElement(name = "firstname")
		List<String> firstname = new ArrayList<String>();
		List<String> getFirstName()	{return firstname;}

		@XmlElement(name = "lastname")
		List<String> lastname = new ArrayList<String>();
		List<String> getLastName()	{return lastname;}
		
		@XmlElement(name = "title")
		List<String> title = new ArrayList<String>();
		List<String> getTitles() 	{return title;}
		
		@XmlElement(name = "hiredate")
		List<String> hiredate = new ArrayList<String>();
		List<String> getHireDate()	{return hiredate;}
		
		@XmlElement(name = "phone")
		List<String> phone = new ArrayList<String>();
		List<String> getPhone() 	{return phone;}
		
		@XmlElement(name = "email")
		List<String> email = new ArrayList<String>();
		List<String> getEmails() 	{return email;}

	}
}
