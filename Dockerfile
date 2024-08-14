FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine-jdk

COPY --from=build /target/token-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar","/app.jar" ]