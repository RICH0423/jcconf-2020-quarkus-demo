# book-service project

Build RESTful API with Quarkus and JPA 

## Creating the Maven project
```bash
mvn io.quarkus:quarkus-maven-plugin:1.9.2.Final:create \
    -DprojectGroupId=com.rich \
    -DprojectArtifactId=book-service \
    -DclassName="com.rich.quarkus.BookResource" \
    -Dpath="/books" \
    -Dextensions="resteasy-jackson"
```

## Displays a list of goals for Quarkus Plugin 
```bash
mvn help:describe -Dplugin=io.quarkus:quarkus-maven-plugin \
    -Ddetail=true
```

### Book api endpoints
- /books
- /openapi
- /swagger-ui

--- 

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `book-service-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/book-service-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/book-service-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.