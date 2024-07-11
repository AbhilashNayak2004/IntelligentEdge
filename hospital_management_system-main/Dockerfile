FROM openjdk:11-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the project files to the container
COPY . .

# Build the project
RUN ./mvnw package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/myapp.jar"]
