FROM openjdk:8-jdk-alpine

COPY target/*.jar /card-service.jar

CMD ["java", "-jar", "/card-service.jar"]
