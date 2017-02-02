FROM openjdk:8-jdk

MAINTAINER juliens@microsoft.com

#ENV PUMRP_MONGO_NAME

WORKDIR /app

COPY src .

RUN /app/gradlew build -x test

EXPOSE 8080

ENTRYPOINT sh run.sh
