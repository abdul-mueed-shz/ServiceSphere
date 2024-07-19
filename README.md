# ServiceSphere

Welcome to the E-Commerce Application ServiceSphere's repository. This project is built using Spring Boot and follows a microservices architecture with a monorepo structure. It includes various components such as a discovery server, config server, Spring Cloud Gateway, and uses Keycloak for authentication and authorization.

## Table of Contents
- [Overview](#overview)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Services](#services)
- [Configuration](#configuration)
- [Authentication & Authorization](#authentication--authorization)
- [Running the Application](#running-the-application)

## Overview
This project is an e-commerce platform that provides a scalable and modular approach to building an online marketplace. The application leverages Spring Boot and Spring Cloud to create a robust microservices ecosystem.

## Architecture
- **Discovery Server**: Uses Spring Cloud Netflix Eureka for service discovery.
- **Config Server**: Manages external configurations for all microservices using Spring Cloud Config.
- **API Gateway**: Utilizes Spring Cloud Gateway to route requests to appropriate microservices.
- **Authentication & Authorization**: Implemented with Keycloak for securing the application.

## Getting Started
To get started with this project, you will need to have the following installed on your machine:
- Java 11+
- Maven 3.6+
- Docker (for running Keycloak)

Clone the repository:
```bash
git clone https://github.com/your-username/e-commerce-app.git
```

## Services
```bash
cd e-commerce-app

cd discovery-server
mvn spring-boot:run

cd config-server
mvn spring-boot:run

cd api-gateway
mvn spring-boot:run
```

## Configuration

### Config Server Configuration
The Config Server reads configuration properties from a Git repository. Ensure you have a repository with the necessary configuration files.

### Application Configuration
Each microservice reads its configuration from the Config Server. Update the `bootstrap.yml` or `application.yml` files in each service to point to the Config Server.

### Authentication & Authorization
Keycloak is used for authentication and authorization. Follow these steps to set up Keycloak:

1. Pull the Keycloak Docker image and run:
   ```bash
   docker pull jboss/keycloak
   docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak
   ```
## Running the Application
Start the services in the following order:

1. Config Server
2. Discovery Server
3. API Gateway
4. Other microservices

Use the following command to start each service:

```bash
mvn spring-boot:run
```
