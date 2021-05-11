package com.lombok.main;

import com.lombok1.val.Val;
import com.lombok2.var.Var;
import com.lombok3.nonNull.NonNullExample;
import com.lombok3.nonNull.NonNullExampleWithConstructor;
import com.lombok4.cleanup.CleanupExample;
import com.lombok5.getterAndSetter.GetterAndSetterOnClass;
import com.lombok5.getterAndSetter.GetterAndSetterOnFields;
import com.lombok5.getterAndSetter.GetterAndSetterWithAccessLevel;
import com.lombok5.getterAndSetter.GetterAndSetterWithAccessLevelNone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.io.IOException;
import java.time.LocalDate;

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
		getterAndSetterExample();
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

	private void getterAndSetterExample()
	{
		String value = "@Getter/@Setter";
		headerAndFooter(value);

		getterAndSetterOnFields();
		getterAndSetterOnClassLevel();
		getterAndSetterWithAccessLevel();
		getterAndSetterWithAccessLevelNone();

		headerAndFooter(value);
	}

	private void getterAndSetterOnFields()
	{
		System.out.println("*** On Fields ***");

		GetterAndSetterOnFields onFields = new GetterAndSetterOnFields();
		onFields.setId(1L);
		onFields.setProductCategory("Laptop");
		onFields.setModelName("Macbook Air M1");

		System.out.println(onFields);
	}

	private void getterAndSetterOnClassLevel()
	{
		System.out.println("*** On Class ***");

		GetterAndSetterOnClass onClass = new GetterAndSetterOnClass();
		onClass.setId(1L);
		onClass.setName("Harish");
		onClass.setDateOfBirth(LocalDate.of(1997, 07, 06));

		System.out.println(onClass);
	}

	public void getterAndSetterWithAccessLevel()
	{
		System.out.println("*** With AccessLevel ***");

		GetterAndSetterWithAccessLevel withAccessLevel = new GetterAndSetterWithAccessLevel
				("Harish", "FullStack Microservices Developer", 3);

		System.out.println(withAccessLevel);
	}

	public void getterAndSetterWithAccessLevelNone()
	{
		System.out.println("*** With AccessLevel.NONE ***");

		GetterAndSetterWithAccessLevelNone withAccessLevelNone = new GetterAndSetterWithAccessLevelNone
				("XYZ", "FullStack Microservices Developer", 5);

		System.out.println(withAccessLevelNone);
	}

	private void headerAndFooter(String val) {
		System.out.println("\n**************** Project Lombok: "+ val + " ****************\n");
	}
}
