# first of all we need JDK for the Application
FROM amazoncorretto:17

# The location where the JAR files in our project will run in Docker
ARG JAR_FILE=target/*.jar

#Copy the jar file into root with this name
COPY ${JAR_FILE} devops-pipeline-application.jar

#The port where the project will run
EXPOSE 8080

# update linux area
CMD apt-get update-y

#It makes our application work
ENTRYPOINT ["java", "-jar", "/application.jar"]