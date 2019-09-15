package core;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.*;
import java.net.*;
import java.util.*;
import org.testng.annotations.*;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import io.qameta.allure.*;
import okhttp3.*;
import okhttp3.Request.Builder;

@Epic("BAT")
@Feature("XSD Validation Test")
public class XSDValidationTest {
	String csvFile = "./xsd_validation_pass.csv";
	// String csvFile = System.getProperty("testcases"); // mvn site -Dtestcases="./xsd_validation_all.csv"

	@DataProvider(name = "dp")
	public Iterator<String[]> a2d() throws InterruptedException, IOException {
		String cvsLine = "";
		String[] a = null;
		ArrayList<String[]> al = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		while ((cvsLine = br.readLine()) != null) {a = cvsLine.split(",");al.add(a);}
		br.close();
		return al.iterator();
	}
	@Step("Test Case: {0}")
	@Test(dataProvider = "dp")
	@Description("XML Validation using SchemaFactory")
	public void test(String tc_id, String xsd_file, String xml_url) throws Exception {
		// System.out.println(tc_id);
		assertThat(validateXMLSchema(new File(xsd_file), new URL(xml_url)), equalTo(true));
	}
	public static boolean validateXMLSchema(File xsd_file, URL xml_url) throws Exception {
		OkHttpClient client = new OkHttpClient();
		Builder b = new Request.Builder();
		ByteArrayInputStream xml_str = new ByteArrayInputStream(
				client.newCall(b.url(xml_url).get().build()).execute().body().string().getBytes());
		SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(xsd_file).newValidator()
				.validate(new StreamSource(xml_str));
		return true;
	}
}
