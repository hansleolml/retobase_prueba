FROM maven:3.6.3-jdk-8 AS build
COPY src /home/app/src
copy pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=build "home/app/target/microservicios-backend-retoibm-1.0.0-SNAPSHOT.jar" "app.jar"
EXPOSE 3081
HEALTHCHECK CMD curl --fail http://localhost:3081/ || exit 1
ENTRYPOINT ["java","-jar","app.jar"]
