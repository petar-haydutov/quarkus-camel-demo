# Quarkus-camel-demo
A demo showcasing how to use apache camel on Quarkus

TIP: Check the https://camel.apache.org/camel-quarkus/latest/first-steps.html Camel Quarkus User guide for prerequisites
and other general information.

### How to start in the Development mode
```bash
$ mvn clean compile quarkus:dev
```

The above command compiles the project, starts the application and lets the Quarkus tooling watch for changes in your
workspace. Any modifications in your project will automatically take effect in the running application.

You can refer to the Development mode section of
https://camel.apache.org/camel-quarkus/latest/first-steps.html#_development_mode for more details.

Hit the following endpoint with a GET/POST request:

* http://localhost:8080/fruits

You can also open the following endpoint in your browser to view the Quarkus dev console:

* http://localhost:8080/q/dev

### How to package and run the application

Once you are done with developing you may want to package and run the application.

#### JVM mode

```bash
$ mvn clean package
$ java -jar target/camel-quarkus-demo-2.2.0-SNAPSHOT-runner.jar
```

#### Native mode

IMPORTANT: Native mode requires having GraalVM and other tools installed. Please check the Prerequisites section
of https://camel.apache.org/camel-quarkus/latest/first-steps.html#_prerequisites.

To prepare and run a native executable using GraalVM, run the following commands:

```bash
$ mvn clean package -Pnative
$ ./target/*-runner
```

Find more details about the JVM mode and Native mode in the Package and run section of
https://camel.apache.org/camel-quarkus/latest/first-steps.html#_package_and_run_the_application.
