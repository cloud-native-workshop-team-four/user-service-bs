FROM maven:3.6-jdk-11-slim as BUILD
COPY . /src
WORKDIR /src
RUN mvn install -DskipTests
FROM openjdk:8-jre
COPY target/*.jar .
EXPOSE 8003
CMD ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]
