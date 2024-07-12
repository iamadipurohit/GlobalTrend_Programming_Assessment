package com.example.Assignment;

import Assignment.Third.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);

		SampleService sampleService = context.getBean(SampleService.class);

		sampleService.someMethod();
	}
}
