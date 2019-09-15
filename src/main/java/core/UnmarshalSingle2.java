package core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;

public class UnmarshalSingle2 {

	public static void main(String[] args) throws Exception {

		String xml = "http://alex.academy/xml/customer.xml";
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xml);
		doc.getDocumentElement().normalize();
//		File doc = new File("customer.xml");
		Customer s = (Customer) JAXBContext.newInstance(Customer.class).createUnmarshaller().unmarshal(doc);

		System.out.println(
				"Customer ID: " + s.getId() 	+ "\n" + 
				"First Name: " 	+ s.getFirstName() 	+ "\n" + 
				"Last Name: " 	+ s.getLastName() 	+ "\n" + 
				"Phone: " 		+ s.getPhone() 		+ "\n" + 
				"Email: " 		+ s.getEmail());
	}
}

