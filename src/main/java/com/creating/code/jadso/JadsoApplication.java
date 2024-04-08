package com.creating.code.jadso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.creating.code.jadso"})

public class JadsoApplication {

	public static void main(String[] args) {
		System.out.println("Hellow ADSO, This is my Aplication!");
		SpringApplication.run(JadsoApplication.class, args);
	}
}
