FROM openjdk:jre-alpine
MAINTAINER Martin Dilger <martin@effectivetrainings.de>

RUN apk update && apk add curl
#HEALTHCHECK CMD curl -f http://localhost:8080/health || exit 1;

ADD target/healthcheck-0.0.1-SNAPSHOT.jar /app.jar 
ENTRYPOINT ["java", "-jar", "/app.jar"]


