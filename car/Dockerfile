# Dockerfile for car microservice
FROM openjdk:17
WORKDIR /app
COPY target/car-0.0.1-SNAPSHOT.jar /app/car.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/app/car.jar"]
