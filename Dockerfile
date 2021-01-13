FROM adoptopenjdk/maven-openjdk8
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app/
RUN mvn package -Dmaven.test.skip=true
EXPOSE 8081
CMD java -jar target/fpoapp-0.0.1.jar


