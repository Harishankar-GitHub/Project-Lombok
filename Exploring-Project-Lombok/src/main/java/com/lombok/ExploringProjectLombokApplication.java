package com.lombok;

import com.lombok.examples.builder.BuilderExample;
import com.lombok.examples.cleanup.CleanupExample;
import com.lombok.examples.constructors.AllArgsConstructorExample;
import com.lombok.examples.constructors.NoArgsConstructorExample;
import com.lombok.examples.constructors.RequiredArgsConstructorExample;
import com.lombok.examples.data.DataExample;
import com.lombok.examples.equalshashcode.EqualsAndHashCodeExample;
import com.lombok.examples.gettersetter.GetterAndSetterOnClass;
import com.lombok.examples.gettersetter.GetterAndSetterOnFields;
import com.lombok.examples.gettersetter.GetterAndSetterWithAccessLevel;
import com.lombok.examples.gettersetter.GetterAndSetterWithAccessLevelNone;
import com.lombok.examples.lazygetter.LazyGetterExample;
import com.lombok.examples.locking.SynchronizedAndLockedExample;
import com.lombok.examples.log.LogExample;
import com.lombok.examples.nonnull.NonNullExample;
import com.lombok.examples.nonnull.NonNullExampleWithConstructor;
import com.lombok.examples.nonnull.NonNullWithGetterAndSetter;
import com.lombok.examples.sneakythrows.SneakyThrowsExample;
import com.lombok.examples.tostring.DefaultToString;
import com.lombok.examples.tostring.ToStringExclude;
import com.lombok.examples.tostring.ToStringInclude;
import com.lombok.examples.tostring.ToStringWithCallSuper;
import com.lombok.examples.tostring.ToStringWithIncludeFieldNames;
import com.lombok.examples.tostring.ToStringWithMethod;
import com.lombok.examples.tostring.ToStringWithNameAndRank;
import com.lombok.examples.val.Val;
import com.lombok.examples.value.RecordExample;
import com.lombok.examples.value.ValueExample;
import com.lombok.examples.var.Var;
import com.lombok.examples.with.WithExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// All the examples are in sub-packages of com.lombok, so the default component scan finds them.
@SpringBootApplication
public class ExploringProjectLombokApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExploringProjectLombokApplication.class, args);
	}

	@Autowired Val val;
	@Autowired Var var;
	@Autowired NonNullExample nonNull;
	@Autowired CleanupExample cleanupExample;
	@Autowired LogExample logExample;

	String value;

	@Override
	public void run(String... args) throws Exception {
		valExample();
		varExample();
		nonNullExample();
		cleanupExample();
		getterAndSetterExample();
		toStringExample();
		equalsAndHashCodeExample();
		constructorsExample();
		dataExample();
		valueExample();
		recordExample();
		builderExample();
		withExample();
		logExample();
		sneakyThrowsExample();
		lazyGetterExample();
		synchronizedAndLockedExample();
	}

	private void valExample() {
		value = "@val";
		headerAndFooter(value);

		System.out.println("Val Example 1: " + val.example1());
		System.out.println("Val Example 2: ");
		val.example2();

		headerAndFooter(value);
	}

	private void varExample() {
		value = "@var";
		headerAndFooter(value);

		var.example();

		headerAndFooter(value);
	}

	private void nonNullExample() {
		value = "@NonNull";
		headerAndFooter(value);

		nonNull.example("A valid String");
		nonNull.example("");
		try {
			nonNull.example(null);
		} catch (IllegalArgumentException e) {
			System.out.println("Method parameter: " + e.getMessage());
		}

		new NonNullExampleWithConstructor("I'm a String passed to the Constructor!");
		try {
			new NonNullExampleWithConstructor(null);
		} catch (IllegalArgumentException e) {
			System.out.println("Constructor parameter: " + e.getMessage());
		}

		NonNullWithGetterAndSetter withGetterAndSetter = new NonNullWithGetterAndSetter();
		withGetterAndSetter.setReviewTitle("Review title");
		withGetterAndSetter.setReviewDescription("Review description");
		System.out.println(withGetterAndSetter);
		try {
			withGetterAndSetter.setReviewTitle(null);		// ReviewTitle is marked as @NonNull.
		} catch (IllegalArgumentException e) {
			System.out.println("Setter: " + e.getMessage());
		}
		// NOTE: IllegalArgumentException is thrown instead of the default NullPointerException
		// because of lombok.nonNull.exceptionType in lombok.config.

		headerAndFooter(value);
	}

	private void cleanupExample() throws IOException {
		value = "@Cleanup";
		headerAndFooter(value);

		cleanupExample.example();

		headerAndFooter(value);
	}

	private void getterAndSetterExample() {
		value = "@Getter/@Setter";
		headerAndFooter(value);

		getterAndSetterOnFields();
		getterAndSetterOnClassLevel();
		getterAndSetterWithAccessLevel();
		getterAndSetterWithAccessLevelNone();

		headerAndFooter(value);
	}

	private void getterAndSetterOnFields() {
		System.out.println("*** On Fields ***");

		GetterAndSetterOnFields onFields = new GetterAndSetterOnFields();
		onFields.setId(1L);
		onFields.setProductCategory("Laptop");
		onFields.setModelName("Macbook Air M1");

		System.out.println(onFields);
	}

	private void getterAndSetterOnClassLevel() {
		System.out.println("*** On Class ***");

		GetterAndSetterOnClass onClass = new GetterAndSetterOnClass();
		onClass.setId(1L);
		onClass.setName("Harish");
		onClass.setDateOfBirth(LocalDate.of(1997, 7, 6));

		System.out.println(onClass);
	}

	private void getterAndSetterWithAccessLevel() {
		System.out.println("*** With AccessLevel ***");

		GetterAndSetterWithAccessLevel withAccessLevel = new GetterAndSetterWithAccessLevel
				("Harish", "FullStack Microservices Developer", 3);

		System.out.println(withAccessLevel);
	}

	private void getterAndSetterWithAccessLevelNone() {
		System.out.println("*** With AccessLevel.NONE ***");

		GetterAndSetterWithAccessLevelNone withAccessLevelNone = new GetterAndSetterWithAccessLevelNone
				("XYZ", "FullStack Microservices Developer", 5);

		System.out.println(withAccessLevelNone);
	}

	private void toStringExample() {
		value = "@ToString";
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

	private void equalsAndHashCodeExample() {
		value = "@EqualsAndHashCode";
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

	private void constructorsExample() {
		value = "@NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor";
		headerAndFooter(value);

		System.out.println("Printing @NoArgsConstructor using @ToString: " +
				new NoArgsConstructorExample());

		System.out.println("Printing @RequiredArgsConstructor using @ToString: " +
				RequiredArgsConstructorExample.of    // Calling the Constructor using the static name. ClassName.of(Args0, Args1..).
						("Harish",
								"ABC Company",
								3,
								"Awesome team",
								"Cool manager"));

		System.out.println("Printing @AllArgsConstructor using @ToString: " +
				AllArgsConstructorExample.of    // Calling the Constructor using the static name. ClassName.of(Args0, Args1..).
						("Harish",
								"ABC Company",
								3,
								null,
								null));

		headerAndFooter(value);
	}

	private void dataExample() {
		value = "@Data";
		headerAndFooter(value);

		// @RequiredArgsConstructor
		DataExample dataExample = new DataExample("Harish",
				"ABC Company",
				3);

		System.out.println("Printing ToString() of DataExample: " + dataExample);
		dataExample.setTeamName("Team Name set using Setter Method");
		System.out.println("Using Getter and Setter Methods of DataExample: " + dataExample.getTeamName());

		headerAndFooter(value);
	}

	private void valueExample() {
		value = "@Value";
		headerAndFooter(value);

		ValueExample valueExample = new ValueExample("Company Name", 3, "Amazing Team", "Cool Manager");
		System.out.println("Printing fields using Getter Methods:");
		System.out.println("Company: " + valueExample.getCompanyName());
		System.out.println("Printing @ToString: " + valueExample);

//		valueExample.setCompanyName("Company Name - Updated");
//		Setter Methods are not generated, as @Value makes all the fields final.
//		(The class is also made final, which only means it can't be extended.)

		headerAndFooter(value);
	}

	private void recordExample() {
		value = "Java record (compared with @Value)";
		headerAndFooter(value);

		RecordExample recordExample = new RecordExample("Company Name", 3, "Amazing Team", "Cool Manager");
		System.out.println("Company using the accessor method: " + recordExample.companyName());
		System.out.println("Printing toString(): " + recordExample);
		System.out.println("equals() is generated too: " +
				recordExample.equals(new RecordExample("Company Name", 3, "Amazing Team", "Cool Manager")));

		headerAndFooter(value);
	}

	private void builderExample() {
		value = "@Builder";
		headerAndFooter(value);

		BuilderExample builderExample = BuilderExample.builder()
				.employeeName("Harish")
				.companyName("ABC Company")
				.skill("Java")
				.skill("Spring Boot")
				.build();
		System.out.println("Built using the builder: " + builderExample);
		// yearsOfExperience is 1 because of @Builder.Default, even though it isn't set above.

		BuilderExample withMoreSkills = builderExample.toBuilder()
				.yearsOfExperience(3)
				.skills(List.of("Docker", "Kubernetes"))
				.build();
		System.out.println("Copied using toBuilder(): " + withMoreSkills);
		System.out.println("The original is unchanged: " + builderExample);

		headerAndFooter(value);
	}

	private void withExample() {
		value = "@With";
		headerAndFooter(value);

		WithExample withExample = new WithExample("Harish", "ABC Company", 3);
		WithExample promoted = withExample.withYearsOfExperience(4);
		System.out.println("Original: " + withExample);
		System.out.println("Copy with yearsOfExperience changed: " + promoted);
		System.out.println("Same value returns the same object: " +
				(withExample == withExample.withCompanyName("ABC Company")));

		headerAndFooter(value);
	}

	private void logExample() {
		value = "@Slf4j";
		headerAndFooter(value);

		logExample.example();

		headerAndFooter(value);
	}

	private void sneakyThrowsExample() {
		value = "@SneakyThrows";
		headerAndFooter(value);

		SneakyThrowsExample sneakyThrowsExample = new SneakyThrowsExample();
		System.out.println("Encoded without a try/catch: " + sneakyThrowsExample.encode("Project Lombok & Java"));
		try {
			sneakyThrowsExample.fail();
		} catch (Exception e) {
			System.out.println("Caught " + e.getClass().getName() + " (a checked exception): " + e.getMessage());
		}

		headerAndFooter(value);
	}

	private void lazyGetterExample() {
		value = "@Getter(lazy = true)";
		headerAndFooter(value);

		LazyGetterExample lazyGetterExample = new LazyGetterExample();
		System.out.println("Object created. The value isn't computed yet.");
		System.out.println("1st call: " + lazyGetterExample.getExpensiveValue());
		System.out.println("2nd call: " + lazyGetterExample.getExpensiveValue());

		headerAndFooter(value);
	}

	private void synchronizedAndLockedExample() throws InterruptedException {
		value = "@Synchronized, @Locked";
		headerAndFooter(value);

		SynchronizedAndLockedExample example = new SynchronizedAndLockedExample();
		Runnable task = () -> {
			for (int i = 0; i < 10_000; i++) {
				example.incrementSynchronizedCounter();
				example.incrementLockedCounter();
			}
		};

		// Two threads increment the counters at the same time.
		// Without the locks, some increments would be lost and the counters would be less than 20000.
		Thread thread1 = Thread.ofVirtual().start(task);
		Thread thread2 = Thread.ofVirtual().start(task);
		thread1.join();
		thread2.join();

		System.out.println("@Synchronized counter: " + example.getSynchronizedCounter());
		System.out.println("@Locked counter: " + example.getLockedCounter());

		headerAndFooter(value);
	}

	private void headerAndFooter(String val) {
		System.out.println("\n**************** Project Lombok: "+ val + " ****************\n");
	}
}
