FROM openjdk:11-jre-slim

COPY target/powerledger-0.0.1-SNAPSHOT.jar powerledger-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","powerledger-0.0.1-SNAPSHOT.jar"]

