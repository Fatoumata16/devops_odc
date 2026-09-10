#FROM eclipse-temurin:17-jre
#WORKDIR /app
#COPY target/*.jar app.jar
#EXPOSE 8087
#LABEL authors="fatoumatadembele"
#
#ENTRYPOINT ["java", "-jar","app.jar"]
#
#FROM eclipse-temurin:17-jre
#
#WORKDIR /app
#
#COPY target/*.jar app.jar
#
#EXPOSE 8085
#
#LABEL authors="fatoumatadembele"
#
#ENTRYPOINT ["java", "-jar", "app.jar"]
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8086

LABEL authors="fatoumatadembele"

ENTRYPOINT ["java", "-jar", "app.jar"]