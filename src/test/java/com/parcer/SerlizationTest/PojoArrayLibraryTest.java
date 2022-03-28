package com.parcer.SerlizationTest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.testng.annotations.Test;

import com.parcer.pojo.PojoArrayLibrary;

public class PojoArrayLibraryTest {
	@Test
	public void serlization() throws JsonGenerationException, JsonMappingException, IOException {

		int[] a = { 987654321, 789456123, 456123987 };
		PojoArrayLibrary pojo = new PojoArrayLibrary("Suraj", "TY002", "sjn6724@hmail.com", a);

		ObjectMapper mapper = new ObjectMapper();
		
		String creat = mapper.writeValueAsString(pojo);
		System.out.println(creat);

		ObjectWriter value = mapper.writerWithDefaultPrettyPrinter();
		File f = new File("./json/Arrayjson.json");
		value.writeValue(f, pojo);
	}
}
