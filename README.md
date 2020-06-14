# Example project with 2 Spring Boot REST services, using PostgreSQL database and Docker Compose

This is a quick project to illustrate the usage of Docker Compose to connect PostgreSQL database with Spring Boot web app and also integrate a REST service with one another to imitate 3rd party integration for fetching data.

## Description

There are 2 SpringBoot REST services - one is simulating a travel offers provider with the destination and price info and the other is acting like a travel offer aggregator trying to find the cheapest offer by fetching the data from the provider. Dummy data is inserted into the database on startup and can be tested using curl:

Fetch all available travel offers from the provider service:
```
curl --location --request GET 'http://localhost:8081/traveloffers'
```
Fetch specific travel offers directly from the provider service:
```
curl --location --request GET 'http://localhost:8081/traveloffers?source=Novi%20Sad&destination=Brisbane'
```
Find the cheapest offer for source/destination combination through the aggregator service:
```
curl --location --request GET 'http://localhost:8082/cheapestoffer?source=Novi%20Sad&destination=Brisbane'
```

## Running the project

To build the project and run unit tests, just run:
```
./mvnw clean install
```

After a successful build, apps should be started using docker-compose:
```
docker-compose up --build
```
