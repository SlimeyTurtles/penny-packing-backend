FROM eclipse-temurin:17-JDK-jammy as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY .mvnw pom.xml ./
RUN ./mvnw dependencies:go-offline
COPY .src .src
RUN .mvnw clean install

FROM eclipse-temurin:17-JRE-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]