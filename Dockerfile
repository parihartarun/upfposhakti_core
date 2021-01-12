FROM adoptopenjdk/maven-openjdk8
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app/
RUN mvn install
RUN mvn package
EXPOSE 8080
CMD java -jar target/fpoapp-0.0.1.jar


