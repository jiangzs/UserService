#FROM java:8-jre
#VOLUME /tmp
#ADD user_service.jar app.jar
#RUN bash -c 'touch /app.jar'
#EXPOSE 8181
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


FROM openjdk:8-jre-alpine
EXPOSE 8181
ADD user_service.jar /app.jar
CMD ["java", "-jar", "/app.jar"]