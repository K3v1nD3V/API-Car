FROM openjdk:17-jdk-alpine

COPY target/jadso-0.0.1-SNAPSHOT.jar jadso-1.0.0.jar

ENTRYPOINT [ "java", "-jar", "jadso-1.0.0.jar" ]