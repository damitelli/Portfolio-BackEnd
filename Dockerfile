FROM amazoncorretto:8-alpine-jdk

MAINTAINER damitelli

COPY target/portfolio.jar portfolio.jar

ENTRYPOINT ["java","-jar","/portfolio.jar"]