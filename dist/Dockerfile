FROM openjdk:8-jre
VOLUME /tmp
EXPOSE 8080
ADD spotippos.jar app.jar
RUN sh -c "chmod +x /app.jar"
ENTRYPOINT [ "java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","app.jar"]
