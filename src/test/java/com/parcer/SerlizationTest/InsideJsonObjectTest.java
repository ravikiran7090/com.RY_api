package com.parcer.SerlizationTest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.parcer.pojo.PojoArrayLibrary2WithAnotherObject;
import com.parcer.pojo.PojoLibrary;

public class InsideJsonObjectTest {
	@Test
	public void multiObjectSerlization() throws JsonGenerationException, JsonMappingException, IOException {
		
		int[] a = { 789, 456, 123 };
		PojoLibrary ps1 = new PojoLibrary("SundaySurya", "TY002", "sjn6724@gmail.com", 456123);
		PojoLibrary ps2 = new PojoLibrary("MondaySurya", "TY003", "sjn6724@gmail.com", 789123);
		Object[] ps= {ps1,ps2};
		PojoArrayLibrary2WithAnotherObject pm = new PojoArrayLibrary2WithAnotherObject("Suraj", "TY001", "suj6724@gmail.com", a, ps);
		
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println(mapper.writeValueAsString(ps1));
		System.out.println(mapper.writeValueAsString(ps2));
		System.out.println(mapper.writeValueAsString(pm));
		
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./json/multiObject.json"), pm);

	}
}
