package com.qa.aprenable2;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NewDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NewDemoApplication.class, args);

		Object byName = context.getBean("timeBean");
		LocalTime byType = context.getBean(LocalTime.class);
		LocalTime byBoth = context.getBean("timeBean", LocalTime.class);

		System.out.println(byName);
		System.out.println(byType);
		System.out.println(byBoth);
	}

}
