FROM eclipse-temurin:21-jdk

RUN echo "Java image downloaded"

WORKDIR /app

RUN echo "Working directory created"

COPY target/CRUD-0.0.1-SNAPSHOT.jar app.jar

RUN echo "JAR copied successfully"

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]