FROM openjdk:11
COPY target/linKazar*.jar /usr/src/linKazar.jar
COPY src/main/resources/application.properties /opt/conf/application.properties
CMD ["java", "-jar", "/usr/src/linKazar.jar", "--spring.config.location=file:/opt/conf/application.properties"]
