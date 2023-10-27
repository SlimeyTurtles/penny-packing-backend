FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT [ "java", "-jar", "/opt/app/*.jar" ]

# FROM maven:3.6.3-jdk-8-slim AS build
# ENTRYPOINT ["mvn"]
# CMD ["package"]

# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# ENTRYPOINT ["java","-jar","/app.jar"]