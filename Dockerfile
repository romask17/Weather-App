FROM java:8-jre
MAINTAINER Roman S.A. <raskidan@ya.ru>
ADD ./build/libs/WeatherApp.jar /app/
CMD ["java", "-jar", "/app/WeatherApp.jar"]
EXPOSE 8080