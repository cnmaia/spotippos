FROM openjdk:7
ADD scp-services.jar app.jar
ENTRYPOINT [ "java","-Djava.security.egd=file:/dev/./urandom","-Xms2g","-jar","-Dspring.profiles.active=env","app.jar"]