FROM java:8

MAINTAINER Dejan Vasic

ENV PORT_NUMBER=8080
ENV BASE_ADDRESS=0.0.0.0

WORKDIR /app

COPY target /app

EXPOSE 8080

CMD ["java","-jar","/app/mailord-api-1.0-SNAPSHOT-jar-with-dependencies.jar"]