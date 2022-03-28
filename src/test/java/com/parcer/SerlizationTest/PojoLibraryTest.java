package com.parcer.SerlizationTest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.parcer.pojo.PojoLibrary;

public class PojoLibraryTest {
	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		
		//we are creating an object into library
		PojoLibrary pobj=new PojoLibrary("Suraj", "TY001", "sjn6724@gmail.com", 70190);
		
		
		//converting java object into json
		//creating object of ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		
		//converting printing the json object into the console
		System.out.println(mapper.writeValueAsString(pobj));
		
		//converting and generating a json file and json data
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./json/jsonFile.json"), pobj);
	}
}

