# Weather App
[![Build Status](https://travis-ci.org/romask17/Weather-App.svg?branch=master)](https://travis-ci.org/romask17/Weather-App) [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

Данное веб-приложение принимает REST-подобный HTTP запрос где передаётся название города (например "Moscow") и код страны (например "ru") и возвращает текущую температуру в этом городе и минимальную из прогнозируемых температур в ближайшие 3 дня в JSON формате.

Для получения температуры приложение использует API OpenWeatherMap: http://openweathermap.org/api

Приложение самодостаточное, запускаться из командной строки и не требует отдельно установленных servlet контейнеров, application серверов и т.п.

* Приложение построено с использованием Spring Boot

## Как запустить

Для сборки используется `Gradle`:

### Windows:

```ps
.\gradlew.bat assemble
```
### Linux:
```sh
./gradlew assemble
```
### Запускаем:
```sh
java -jar ./build/libs/WeatherApp-1.0.0.jar
```
### Проверяем:

```sh
http 'http://localhost:8080/api/v1.0/weather/?countryCode=ru&cityName=moscow'
```
### Получаем:
```sh
HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
Date: Thu, 10 Aug 2017 19:46:16 GMT
Transfer-Encoding: chunked

[
    {
        "dateString": "2017-08-10 09:00:00",
        "minimalTemp": 16.05,
        "temperature": 18.5
    },
    {
        "dateString": "2017-08-11 09:00:00",
        "minimalTemp": 16.9,
        "temperature": 22.93
    },
    {
        "dateString": "2017-08-12 09:00:00",
        "minimalTemp": 13.73,
        "temperature": 23.72
    },
    {
        "dateString": "2017-08-13 09:00:00",
        "minimalTemp": 13.36,
        "temperature": 26.18
    }
]

```
### Docker

Необходим установленный `Docker` и `docker-compose`

Команда: 

```sh
docker-compose up -d 
```
запускает `docker` контейнер на 8080 порту
