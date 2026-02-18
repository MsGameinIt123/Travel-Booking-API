# Use Java runtime
FROM eclipse-temurin:17-jdk

# Copy the built jar into the container
COPY target/*.jar app.jar

# Run the Spring Boot application
ENTRYPOINT ["java","-jar","/app.jar"]