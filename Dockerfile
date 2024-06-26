
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/mascota-0.1.1.jar
COPY ${JAR_FILE} app_veterinaria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_veterinaria.jar"]