package core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;

public class UnmarshalSingle {

	public static void main(String[] args) throws Exception {

		String xml = "http://alex.academy/xml/employee.xml";
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xml);
		doc.getDocumentElement().normalize();
//		File doc = new File("employee.xml");
		Employees o = (Employees) JAXBContext.newInstance(Employees.class).createUnmarshaller().unmarshal(doc);
		Employee s = (Employee) JAXBContext.newInstance(Employee.class).createUnmarshaller().unmarshal(doc);

		for (Employees.Employee emp : o.getEmployees()) {

			List<String> id = new ArrayList<String>();
			id.addAll(emp.getId());
			List<String> fn = new ArrayList<String>();
			fn.addAll(emp.getFirstName());
			List<String> ln = new ArrayList<String>();
			ln.addAll(emp.getLastName());
			List<String> t = new ArrayList<String>();
			t.addAll(emp.getTitles());
			List<String> hd = new ArrayList<String>();
			hd.addAll(emp.getHireDate());
			List<String> p = new ArrayList<String>();
			p.addAll(emp.getPhone());
			List<String> e = new ArrayList<String>();
			e.addAll(emp.getEmails());

			System.out.println("Employee ID: " + id.toString().replaceAll("\\[|\\]", "") + "; " + "First Name: "
					+ fn.toString().replaceAll("\\[|\\]", "") + "; " + "Last Name: "
					+ ln.toString().replaceAll("\\[|\\]", "") + "; " + "Title: "
					+ t.toString().replaceAll("\\[|\\]", "") + "; " + "Hire date: "
					+ hd.toString().replaceAll("\\[|\\]", "") + "; " + "Phone: "
					+ p.toString().replaceAll("\\[|\\]", "") + "; " + "Email: "
					+ e.toString().replaceAll("\\[|\\]", ""));
			}
		
		System.out.println(
				"Employee ID: " + s.employee.id 		+ "; " + 
				"First name: " 	+ s.employee.firstname 	+ "; "+ 
				"Last Name: " 	+ s.employee.lastname 	+ "; " + 
				"Title: " 		+ s.employee.title 		+ "; " + 
				"Hire date: " 	+ s.employee.hiredate 	+ "; " + 
				"Phone: " 		+ s.employee.phone 		+ "; " + 
				"Email: " 		+ s.employee.email);
	}
		
}

