FROM openjdk:8-jre
COPY target/*.jar .
EXPOSE 8003
CMD ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]