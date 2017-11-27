package com.example.cmd;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.pojo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class OmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OmApplication.class, args);
		ObjectMapper mapper = context.getBean(ObjectMapper.class);
		System.out.println(mapper);
		Student s = new Student("tom",25);
		
		try {
			System.out.println(mapper.writeValueAsString(s));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 String json = "{\"name\":\"tom\",\"age\":52}";
	      
	      try {
	             Student p2 = mapper.readValue(json, Student.class);
	             System.out.println(p2);
	      } catch (IOException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	      }
	}
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
