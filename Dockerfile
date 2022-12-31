FROM amazoncorretto:8-alpine-jdk

MAINTAINER damitelli

COPY target/PortfolioSpringBoot-0.0.1-SNAPSHOT.jar PortfolioSpringBoot-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/PortfolioSpringBoot-0.0.1-SNAPSHOT.jar"]