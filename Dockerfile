FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
COPY target/*.jar /opt/restaurant-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar restaurant-service.jar