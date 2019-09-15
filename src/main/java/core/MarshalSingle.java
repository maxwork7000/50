package core;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class MarshalSingle {
	
	public static void main(String[] args) throws Exception {

		Customer o = new Customer();
		o.setId("123456");
		o.setFirstName("Alex");
		o.setLastName("Moore");
		o.setPhone("415 555-1212");
		o.setEmail("alex_moore@gmail.com");

		File doc = new File("customer.xml");

		Marshaller xml = JAXBContext.newInstance(Customer.class).createMarshaller();
		xml.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		xml.marshal(o, doc);
		xml.marshal(o, System.out);
	}
}