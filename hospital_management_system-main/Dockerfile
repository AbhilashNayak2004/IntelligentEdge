# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the Spring Boot jar to the container
COPY target/my-spring-boot-app.jar app.jar

# Command to run the application
CMD ["java", "-jar", "app.jar"]

# Expose the port the app runs on
EXPOSE 8080
