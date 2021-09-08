FROM maven:3.6-jdk-11-slim as BUILD
COPY . /src
WORKDIR /src
RUN mvn install -DskipTests

RUN mkdir -p /config/apps && \
    cp ./target/*.*ar /config/apps/

FROM openjdk:8-jre
#COPY target/*.jar .
COPY --chown=1001:0 --from= BUILD /config/apps/ .

EXPOSE 8003
CMD ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]
