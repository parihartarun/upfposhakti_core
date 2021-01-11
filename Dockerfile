# Maven build container 

FROM adoptopenjdk/maven-openjdk8

COPY pom.xml /app/

COPY src /app/src/

WORKDIR /app/

RUN mvn install

RUN mvn package

#pull base image

#FROM openjdk

#expose port 8080
EXPOSE 8080

#COPY ./target/fpoapp-0.0.1.jar ./data/fpoapp-0.0.1.jar

#default command
CMD java -jar target/fpoapp-0.0.1.jar

#copy hello world to docker image from builder image

