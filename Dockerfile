FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./mvnw -q -DskipTests package

FROM eclipse-temurin:21-jre-alpine
COPY --from=build /app/target/gke1-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/app.jar"]
