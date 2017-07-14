FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
ADD spotippos.jar app.jar
RUN sh -c "touch /app.jar"
ENTRYPOINT [ "java","-Djava.security.egd=file:/dev/./urandom","-Xms2g","-jar","-Dspring.profiles.active=local","app.jar"]
