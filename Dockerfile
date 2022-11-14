FROM openjdk:11
ADD target/eurofins-genomics-app.jar eurofins-genomics-rest-app.jar
ADD /src/main/resources/application.properties /app/application.properties
ENTRYPOINT ["java","-jar","eurofins-genomics-rest-app.jar", "--spring.config.location=classpath:file:/app/application-properties"]