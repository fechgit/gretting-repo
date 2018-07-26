FROM openjdk:8-jre-alpine
MAINTAINER Tomas Rosales "ext_tsrosales@Falabella.cl"
ARG WAR_FILE
COPY ${WAR_FILE} /app/Greeting.war
ENV URL_BACKEND http://192.168.42.29:8089/api/random
ENTRYPOINT ["java"]
CMD ["-jar","/app/Greeting.war"]
EXPOSE 9080
RUN apk --update --no-cache add curl
HEALTHCHECK CMD curl -f http://localhost:9080/health || exit 1