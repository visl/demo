##Task

Imagine a modular insurance product.
People can choose from 4 modules.
Each module has a different selectable coverage and a different mathematical risk.
These are the modules:

Bike (Coverage 0-3k, Risk 30%)
Jewellery (Coverage 500-10k, Risk 5%)
Electronics (Coverage 500-6k, Risk 35%)
Sports Equipment (Coverage 0-20k, Risk 30%)

The user should be able to select the coverage for each module.
The price of the tariff, which is the individual configuration for each customer, should be calculated based on the risk.

##How to run instructions

Prerequisite:
JDK 1.8
Maven 3.0+

You can run the application from command line from project home folder using ./mvnw spring-boot:run.
Or you can build the JAR file with ./mvnw clean package. Then you can run the JAR file:
java -jar target/gs-serving-web-content-0.1.0.jar

##Test the App

Now that the web site is running, visit http://localhost:8080
Port can be set via MAVEN_OPTS, see mvnw file.