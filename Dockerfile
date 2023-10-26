FROM maven:3.6.3-jdk-8-slim AS build
ENTRYPOINT ["mvn"]
CMD ["package"]

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ENTRYPOINT ["java","-jar","/app.jar"]