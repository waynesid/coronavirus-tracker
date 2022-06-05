FROM openjdk:17
ADD target/maven-docker-coronavirus-tracker.jar maven-docker-coronavirus-tracker.jar
ENTRYPOINT ["java" ,"-jar" ,"maven-docker-coronavirus-tracker.jar"]
EXPOSE 8080