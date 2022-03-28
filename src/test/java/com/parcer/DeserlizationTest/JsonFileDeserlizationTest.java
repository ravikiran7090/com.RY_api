package com.parcer.DeserlizationTest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.parcer.pojo.PojoArrayLibrary2WithAnotherObject;
import com.parcer.pojo.PojoLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsonFileDeserlizationTest {
	@Test
	public void deserlization() throws JsonParseException, JsonMappingException, IOException {
		WebDriverManager.chromedriver().setup();
		
		ObjectMapper mapper=new ObjectMapper();
		PojoArrayLibrary2WithAnotherObject pobj=mapper.readValue(new File("./json/multiObject.json"), PojoArrayLibrary2WithAnotherObject.class);
		System.out.println(pobj.getName());
		System.out.println(pobj.getEmail());
		System.out.println(pobj.getEmpid());
		System.out.println(pobj.getPhone());
		System.out.println(pobj.getPojoLibrary());

	}
}
