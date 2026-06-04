# Stage 1: Build the application
# We use a Maven image directly because the local Maven wrapper (.mvn) is missing files
FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /app

# Copy all files
COPY . .

# Build the application using Maven directly
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8085

# The entrypoint to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
