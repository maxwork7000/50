package core;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employees")

public class Employee {

	@XmlElement(name = "employee")
	Child employee;

	static class Child {
		
     	String id;
		@XmlAttribute(name = "id")
		public String getId() {return id;}
		public void setId(String id) {this.id = id;}
		
		String firstname;
		@XmlElement(name = "firstname")
		public String getFirstName() {return firstname;}
		public void setFirstName(String firstname) {this.firstname = firstname;}
		
		String lastname;
		@XmlElement(name = "lastname")
		public String getLastName() {return lastname;}
		public void setLastName(String lastname) {this.lastname = lastname;}
			
		String title;
		@XmlElement(name = "title")
		public String getTitle() {return title;}
		public void setTitle(String title) {this.title = title;}
		
		String hiredate;
		@XmlElement(name = "hiredate")
		public String getHireDate() {return hiredate;}
		public void setHireDate(String hiredate) {this.hiredate = hiredate;}
		
		String phone;
		@XmlElement(name = "phone")
		public String getPhone() {return phone;}
		public void setPhone(String phone) {this.phone = phone;}
		
		String email;
		@XmlElement(name = "email")
		public String getEmail() {return email;}
		public void setEmail(String email) {this.email = email;}
	}
}
