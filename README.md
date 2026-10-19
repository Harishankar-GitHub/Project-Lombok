## Project Lombok - A Java Library

[Project Lombok](https://projectlombok.org/) is a Java library that generates boilerplate code at compile time, such as getters, setters, constructors, `equals()`/`hashCode()`, `toString()` and builders, from annotations.

This repository is a set of small, runnable examples, one per Lombok feature. It's a Spring Boot console application: when it runs, it calls each example in turn and prints the result, so you can compare the code with what Lombok generated.

> ***How to run***
- Requires **Java 21** (Spring Boot 4.1, Lombok 1.18.46). No Maven install is needed, as the Maven wrapper is included.
- From the `Exploring-Project-Lombok` folder, run `./mvnw spring-boot:run` (or `mvnw.cmd spring-boot:run` on Windows).
- In the IDE, install the Lombok plugin if needed (IntelliJ has it built in) and enable annotation processing (IntelliJ: *Settings > Build, Execution, Deployment > Compiler > Annotation Processors*), so the generated methods are visible.

Each example prints between a header and a footer. For example, the `@Builder` example prints:

```
**************** Project Lombok: @Builder ****************

Built using the builder: BuilderExample(employeeName=Harish, companyName=ABC Company, yearsOfExperience=1, skills=[Java, Spring Boot])
Copied using toBuilder(): BuilderExample(employeeName=Harish, companyName=ABC Company, yearsOfExperience=3, skills=[Java, Spring Boot, Docker, Kubernetes])
The original is unchanged: BuilderExample(employeeName=Harish, companyName=ABC Company, yearsOfExperience=1, skills=[Java, Spring Boot])

**************** Project Lombok: @Builder ****************
```

> ***Project structure***

```
Exploring-Project-Lombok/
├── lombok.config                         Lombok configuration (e.g. the exception type @NonNull throws)
├── pom.xml
└── src/main/java/com/lombok/
    ├── ExploringProjectLombokApplication.java   Runs every example in order
    └── examples/<feature>/                       One package per feature (see the table below)
```

> ***Links to Code Snippets***

| My Code | Official Doc |
|--|--|
| [@val](Exploring-Project-Lombok/src/main/java/com/lombok/examples/val/Val.java) | [Click here](https://projectlombok.org/features/val) |
| [@var](Exploring-Project-Lombok/src/main/java/com/lombok/examples/var/Var.java) | [Click here](https://projectlombok.org/features/var) |
| [@NonNull](Exploring-Project-Lombok/src/main/java/com/lombok/examples/nonnull) | [Click here](https://projectlombok.org/features/NonNull) |
| [@Cleanup](Exploring-Project-Lombok/src/main/java/com/lombok/examples/cleanup/CleanupExample.java) | [Click here](https://projectlombok.org/features/Cleanup) |
| [@Getter/@Setter](Exploring-Project-Lombok/src/main/java/com/lombok/examples/gettersetter) | [Click here](https://projectlombok.org/features/GetterSetter) |
| [@ToString](Exploring-Project-Lombok/src/main/java/com/lombok/examples/tostring) | [Click here](https://projectlombok.org/features/ToString) |
| [@EqualsAndHashCode](Exploring-Project-Lombok/src/main/java/com/lombok/examples/equalshashcode/EqualsAndHashCodeExample.java) | [Click here](https://projectlombok.org/features/EqualsAndHashCode) |
| [Constructors](Exploring-Project-Lombok/src/main/java/com/lombok/examples/constructors) | [Click here](https://projectlombok.org/features/constructor) |
| [@Data](Exploring-Project-Lombok/src/main/java/com/lombok/examples/data/DataExample.java) | [Click here](https://projectlombok.org/features/Data) |
| [@Value](Exploring-Project-Lombok/src/main/java/com/lombok/examples/value/ValueExample.java) | [Click here](https://projectlombok.org/features/Value) |
| [Java record (vs @Value)](Exploring-Project-Lombok/src/main/java/com/lombok/examples/value/RecordExample.java) | [Click here](https://www.baeldung.com/java-record-vs-lombok) |
| [@Builder](Exploring-Project-Lombok/src/main/java/com/lombok/examples/builder/BuilderExample.java) | [Click here](https://projectlombok.org/features/Builder) |
| [@With](Exploring-Project-Lombok/src/main/java/com/lombok/examples/with/WithExample.java) | [Click here](https://projectlombok.org/features/With) |
| [@Slf4j](Exploring-Project-Lombok/src/main/java/com/lombok/examples/log/LogExample.java) | [Click here](https://projectlombok.org/features/log) |
| [@SneakyThrows](Exploring-Project-Lombok/src/main/java/com/lombok/examples/sneakythrows/SneakyThrowsExample.java) | [Click here](https://projectlombok.org/features/SneakyThrows) |
| [@Getter(lazy = true)](Exploring-Project-Lombok/src/main/java/com/lombok/examples/lazygetter/LazyGetterExample.java) | [Click here](https://projectlombok.org/features/GetterLazy) |
| [@Synchronized / @Locked](Exploring-Project-Lombok/src/main/java/com/lombok/examples/locking/SynchronizedAndLockedExample.java) | [@Synchronized](https://projectlombok.org/features/Synchronized), [@Locked](https://projectlombok.org/features/Locked) |

> ***Seeing the generated code***

Lombok changes the compiled class, not your source file. To see what it generated:
- **IntelliJ:** right-click a class and choose *Refactor > Delombok*. This rewrites the source with the generated code, so use it on a copy or undo afterwards.
- **Command line:** run the delombok tool with the Lombok jar from your Maven repository, e.g. `java -jar lombok.jar delombok src/main/java -d target/delombok`. This writes plain Java versions of the sources to `target/delombok` ([docs](https://projectlombok.org/features/delombok)).
- **Compiled class:** after a build, `javap -p target/classes/com/lombok/examples/data/DataExample.class` lists every generated method.

> ***When to be careful with Lombok***
- **`@Data` / `@EqualsAndHashCode` on JPA entities:** the generated `equals()`/`hashCode()` use every field, including the generated ID and lazy-loaded relations, and `toString()` can trigger lazy loading or loop forever on two-way relations. Prefer `@Getter`/`@Setter` and write `equals()`/`hashCode()` yourself.
- **`@EqualsAndHashCode` with mutable fields:** if a field changes after the object is added to a `HashSet` or used as a `HashMap` key, its hash code changes and the object can't be found any more.
- **`@EqualsAndHashCode` / `@ToString` on subclasses:** parent fields are ignored unless `callSuper = true` is set.
- **`@NonNull` on a field:** it only adds null checks to the generated setter and constructor. The field can still be null, e.g. when the object is created with a no-args constructor.
- **`@Builder` with other constructors:** `@Builder` needs a constructor that takes all the fields. Adding `@NoArgsConstructor` (e.g. for a framework) breaks the build unless `@AllArgsConstructor` is added too.
- **`@SneakyThrows`:** callers can no longer see or catch the checked exception by its type, so use it only where the exception can't really happen.
- **New Java versions:** Lombok hooks into the compiler, so a new JDK often needs a newer Lombok version. This project stopped compiling on Java 21 until Lombok was upgraded.
- **Records:** for simple immutable data classes on Java 16+, a `record` does what `@Value` does without a library.

> ***Official Website/Document links***
- [**Project Lombok - Official Website**](https://projectlombok.org/)
- [Stable Features](https://projectlombok.org/features/)
- [***Lombok Configuration System***](https://projectlombok.org/features/configuration)
- [Experimental Features](https://projectlombok.org/features/experimental/)
- [Delombok](https://projectlombok.org/features/delombok)
- [Lombok Javadoc](https://projectlombok.org/api/)
- [Installing Lombok](https://projectlombok.org/setup/)
- [Lombok Download](https://projectlombok.org/download) and [Lombok Changelog](https://projectlombok.org/changelog)
- [Lombok GitHub](https://github.com/projectlombok)

> ***Some references/examples/blogs***
- [Introduction to Lombok - Baeldung](https://www.baeldung.com/intro-to-project-lombok)
- [Setting up Lombok in Eclipse and IntelliJ - Baeldung](https://www.baeldung.com/lombok-ide)
- [Lombok Example](https://javabydeveloper.com/lombok-spring-boot-example/)
- [Writing More Readable Code with Project Lombok - Medium.com](https://medium.com/@yigitcannalci/how-to-use-project-lombok-with-spring-boot-ac84bd6047d1)
- [Guide to use Lombok In Spring Boot - Medium.com](https://medium.com/spring-boot/guide-to-use-lombok-in-spring-boot-4e2035545f65)
- [Lombok Configuration System - Baeldung](https://www.baeldung.com/lombok-configuration-system)
- [Java Record vs Lombok](https://www.baeldung.com/java-record-vs-lombok)

> ***License***

This project is licensed under the [MIT License](LICENSE).
