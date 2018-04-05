FROM maven:3.3.9-jdk-8

ENV PORT_NUMBER=8080
ENV BASE_ADDRESS=0.0.0.0

RUN mkdir -p /opt/app
WORKDIR /opt/app

COPY pom.xml /opt/app/
RUN mvn install

COPY src /opt/app/src
RUN mvn package

EXPOSE 8080

#CMD ["mvn", "exec:java"]
ENTRYPOINT mvn exec:java