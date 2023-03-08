FROM openjdk:17-jdk-slim
EXPOSE 8085
WORKDIR /app
COPY target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
