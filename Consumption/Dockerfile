FROM openjdk:17
WORKDIR /app
COPY target/consumption-0.0.1-SNAPSHOT.jar /app/consumption.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/app/consumption.jar"]
