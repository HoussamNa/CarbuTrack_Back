FROM openjdk:17
WORKDIR /app
COPY target/client-0.0.1-SNAPSHOT.jar /app/client.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "/app/client.jar"]
