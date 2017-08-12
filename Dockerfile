FROM java:8-jre
MAINTAINER Roman S.A. <raskidan@ya.ru>
ADD ./build/libs/WeatherApp-1.0.0.jar /app/
CMD ["java", "-jar", "/app/WeatherApp-1.0.0.jar"]
EXPOSE 8080