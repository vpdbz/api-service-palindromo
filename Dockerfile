# Build runtime image.
FROM openjdk:8-jre

# Copy the compiled files over.
ADD ./target/api-service-palindromo-1.0.0.jar /app/

# Starts java app
CMD ["java", "-jar", "/app/api-service-palindromo-1.0.0.jar"]