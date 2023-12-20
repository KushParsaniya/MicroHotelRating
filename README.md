# MicroHotelRating 

# Hotel Review Microservice Project

This project is a collection of microservices developed using Spring Boot for managing hotel reviews. It utilizes PostgreSQL and MongoDB as its databases, Netflix Eureka for service registry, an API Gateway, OpenFeign for declarative REST client, and Resilience4j for fault tolerance.

## Overview

The project aims to provide a robust platform for managing hotel reviews through a microservice architecture. It leverages various technologies and frameworks to ensure scalability, fault tolerance, and efficient communication among services.

## Technologies Used

- **Spring Boot**: Framework for creating microservices.
- **PostgreSQL and MongoDB**: Databases used for different aspects of the application.
- **Netflix Eureka**: Service registry for enabling service discovery.
- **API Gateway**: Central entry point to manage API requests.
- **OpenFeign**: Declarative REST client for simplifying communication between services.
- **Resilience4j**: Library for fault tolerance and resilience.

## Modules

1. **Service Registry (Eureka Server)**: Manages service registration and discovery.
2. **API Gateway**: Centralized entry point handling incoming requests.
3. **Hotel Service**: Microservice managing hotel.
4. **User Service**: Microservice managing user.
5. **Review Service**: Microservice managing reviews.
6. **Database Services**: PostgreSQL for relational data and MongoDB for specific data requirements.

## How to Run

1. **Service Setup**: Start by configuring and launching the Eureka service registry.
2. **Start Services**: Launch each microservice (API Gateway, Hotel , User and Review Service, Database Services).
3. **Database Configuration**: Ensure PostgreSQL and MongoDB are correctly configured and running.
4. **Testing APIs**: Utilize the provided API documentation to interact with the services.
