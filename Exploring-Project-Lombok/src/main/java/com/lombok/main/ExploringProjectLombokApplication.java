package com.lombok.main;

import com.lombok1.val.Val;
import com.lombok2.var.Var;
import com.lombok3.nonNull.*;
import com.lombok4.cleanup.CleanupExample;
import com.lombok5.getterAndSetter.*;
import com.lombok6.toString.*;
import com.lombok7.equalsAndHashCode.EqualsAndHashCodeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
	@Autowired NonNullWithGetterAndSetter withGetterAndSetter;

	@Override
	public void run(String... args) throws Exception {

		valExample();
		varExample();
		nonNullExample();
		cleanupExample();
		getterAndSetterExample();
		toStringExample();
		equalsAndHashCodeExample();
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

		new NonNullExampleWithConstructor("I'm a String passed to the Constructor!");
//		new NonNullExampleWithConstructor(null);

//		withGetterAndSetter.setReviewTitle(null);		// ReviewTitle is marked as @NonNull.
//		System.out.println(withGetterAndSetter);
		withGetterAndSetter.setReviewDescription("Review description");
		System.out.println(withGetterAndSetter);

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

	public void toStringExample()
	{
		String value = "@ToString";
		headerAndFooter(value);

		System.out.println(new DefaultToString());
		System.out.println(new ToStringWithIncludeFieldNames());
		System.out.println(new ToStringExclude());
		System.out.println(new ToStringInclude());
		System.out.println(new ToStringWithCallSuper());
		System.out.println(new ToStringWithMethod());
		System.out.println(new ToStringWithNameAndRank());

		headerAndFooter(value);
	}

	public void equalsAndHashCodeExample()
	{
		String value = "@EqualsAndHashCode";
		headerAndFooter(value);

		Set<EqualsAndHashCodeExample> set = new HashSet<>();

		set.add(new EqualsAndHashCodeExample());
		System.out.println("Size of the Set after adding 1st element: " + set.size());
		set.add(new EqualsAndHashCodeExample());
		System.out.println("Size of the Set after adding 2nd element: " + set.size());
		set.add(new EqualsAndHashCodeExample("Jill", "XYZ Company", 3, "Awesome Team !", "Cool Manager"));
		System.out.println("Size of the Set after adding 3rd element: " + set.size());

		System.out.println("EqualsAndHashCode Set has " + set.size() + " elements!");

		headerAndFooter(value);
	}

	private void headerAndFooter(String val) {
		System.out.println("\n**************** Project Lombok: "+ val + " ****************\n");
	}
}
