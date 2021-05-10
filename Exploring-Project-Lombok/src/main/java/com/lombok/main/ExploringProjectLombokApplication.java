package com.lombok.main;

import com.lombok1.val.Val;
import com.lombok2.var.Var;
import com.lombok3.nonNull.NonNullExample;
import com.lombok3.nonNull.NonNullExampleWithConstructor;
import com.lombok4.cleanup.CleanupExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.io.IOException;

@SpringBootApplication
@ComponentScan("com.lombok*")
public class ExploringProjectLombokApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExploringProjectLombokApplication.class, args);
	}

	@Autowired Val val;
	@Autowired Var var;
	@Autowired NonNullExample nonNull;
	@Autowired CleanupExample cleanupExample;

	@Override
	public void run(String... args) throws Exception {

		valExample();
		varExample();
		nonNullExample();
		cleanupExample();
	}

	private void valExample() {
		String value = "@val";
		headerAndFooter(value);

		System.out.println("Val Example 1: " + val.example1());
		System.out.println("Val Example 2: ");
		val.example2();

		headerAndFooter(value);
	}

	private void varExample() {
		String value = "@var";
		headerAndFooter(value);

		var.example();

		headerAndFooter(value);
	}

	private void nonNullExample() {
		String value = "@NonNull";
		headerAndFooter(value);

		nonNull.example("A valid String");
		nonNull.example("");
//		nonNull.example(null);

		NonNullExampleWithConstructor constructorExample;
		constructorExample = new NonNullExampleWithConstructor("I'm a String passed to the Constructor!");
//		constructorExample = new NonNullExampleWithConstructor(null);

		headerAndFooter(value);
	}

	private void cleanupExample() throws IOException
	{
		String value = "@Cleanup";
		headerAndFooter(value);

		cleanupExample.example();

		headerAndFooter(value);
	}

	private void headerAndFooter(String val) {
		System.out.println("\n**************** Project Lombok: "+ val + " ****************\n");
	}
}
