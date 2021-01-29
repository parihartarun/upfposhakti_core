FROM adoptopenjdk/maven-openjdk11
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app/
RUN mvn package -Dmaven.test.skip=true -X
EXPOSE 8081
EXPOSE 80
CMD java -jar target/fpoapp-0.0.1.jar


