package com.lombok.main;

import com.lombok1.val.Val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lombok*")
public class ExploringProjectLombokApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExploringProjectLombokApplication.class, args);
	}

	@Autowired Val val;

	@Override
	public void run(String... args) throws Exception {

		valExample();
	}

	private void valExample() {
		String value = "@val";
		headerAndFooter(value);

		System.out.println("Val Example 1: " + val.example1());
		System.out.println("Val Example 2: ");
		val.example2();

		headerAndFooter(value);
	}

	private void headerAndFooter(String val) {
		System.out.println("\n**************** Project Lombok: "+ val + " ****************\n");
	}
}