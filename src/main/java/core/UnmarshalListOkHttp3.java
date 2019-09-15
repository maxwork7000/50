package core;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.*;
import okhttp3.*;

public class UnmarshalListOkHttp3 {

	public static void main(String[] args) throws Exception {
//		String xml = "http://alex.academy/xml/employees.xml";
		String xml = "http://alex.academy/xml/employees.xml";
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(xml).get().build();
		
//      MediaType mediaType = MediaType.parse("application/xml");
//      RequestBody body = RequestBody.create(mediaType, "<user> </user>");
//      Request request = new Request.Builder().url(xml).post(body).build();
		
		StringReader sr = new StringReader((String) client.newCall(request).execute().body().string());
//		Response response = client.newCall(request).execute();
//		String doc = response.body().string();
//		StringReader sr = new StringReader(doc);
		
		Employees o = (Employees) JAXBContext.newInstance(Employees.class).createUnmarshaller().unmarshal(sr);
		
//		File doc = new File("employees.xml");

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
}
}