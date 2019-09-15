package core;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "customer")
public class Customer {

	@XmlAttribute(name = "id")
	String id;
	String getId() {return id;}
	void setId(String id) {this.id = id;}
	
	@XmlElement(name = "firstname")
	String firstname;
	String getFirstName() {return firstname;}
	void setFirstName(String firstname) {this.firstname = firstname;}
	
	@XmlElement(name = "lastname")
	String lastname;
	String getLastName() {return lastname;}
	void setLastName(String lastname) {this.lastname = lastname;}
		
	@XmlElement(name = "phone")
	String phone;
	String getPhone() {return phone;}
	void setPhone(String phone) {this.phone = phone;}
	
	@XmlElement(name = "email")
	String email;
	String getEmail() {return email;}
	void setEmail(String email) {this.email = email;}
}