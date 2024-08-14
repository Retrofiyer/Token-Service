<div>
    <h1>Token Microservice</h1>
</div>

## About The Project

This microservice is designed to handle the generation and management of tokens for a streaming application. Its primary function is to create secure authentication tokens that are used to 
validate and authorize users on the platform. It works in conjunction with the user registration microservice, ensuring that the tokens generated are unique, secure, and have controlled expiration. 

## Table of Contents

<ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#overview">Overview</a></li>
        <li><a href="#features">Features</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#configuration">Configuration</a></li>
        <li><a href="#running-the-service">Running the service</a></li>
      </ul>
    </li>
    <li>
      <a href="#contributing">Contributing</a>
    </li>
 </ol>

## Overview

The Token Service is a RESTful API built using Spring Boot. This component is essential for maintaining the security and integrity of the authentication system within the streaming platform.

## Features

<div>
  <ul>
      <li> <b>Token Generation:</b> Supports customizable token payloads with user-specific data.</li>
      <li> <b>Token Validation:</b> Verifies token expiration and signature to prevent unauthorized access.</li>
      <li> <b>Token Refresh:</b> Provides functionality to issue new tokens when the existing ones expire, without requiring users to re-authenticate.</li>
    <li> <b>Scalability:</b> Designed to handle high traffic, ensuring reliable token generation and validation even under heavy load.</li>
  </ul>
</div>


## Built With

[![Spring Boot][springboot.com]][springboot-url]
[![PostgreSQL][postgresql.com]][postgresql-url]
[![RabbitMQ][rabbitmq.com]][rabbitmq-url]
[![Swagger][swagger.com]][swagger-url] [![Docker][docker.com]][docker-url]

<!-- GETTING STARTED -->
## Getting Started

## Prerequisites

Before you begin, make sure you have the following tools installed on your machine:

- **Java 17 or higher** - [Download Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Spring Boot 3.3.2** - [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- **Maven** - [Maven](https://maven.apache.org/install.html)

If you don't have any of these tools installed, follow the provided links to install them.


## Installation

1.- Clone the repository
   ```sh
   git clone https://github.com/Retrofiyer/Token-Service.git
   cd Token-Service
   ```
2.- Build project using maven
 ```sh
   mvn clean install
   ```

## Configuration

The configuration for the User Service is located in `src/main/resources/application.properties`. Below is an example configuration:

 ```sh
 spring.datasource.url=jdbc:postgresql://host-name:port/DB-Name
 spring.datasource.username=postgres-username
 spring.datasource.password=postgres-password
   ```

## Running the service

  ```sh
    mvn spring-boot:run
   ```

## Contributing

I would like you to contribute to this project. Whether it's fixing a bug, adding a new feature or improving the documentation, your help is always welcome. Please email me at `sebitas5225@gmail.com` with all the details for improvement.

<!-- LINKS & IMAGES -->

[docker.com]: https://img.shields.io/badge/Docker-black?style=for-the-badge&logo=docker&logoColor=white
[docker-url]: https://www.docker.com/
[springboot.com]: https://img.shields.io/badge/SpringBoot-black?style=for-the-badge&logo=springboot&logoColor=white
[springboot-url]: https://spring.io/projects/spring-boot
[java.com]: https://img.shields.io/badge/Java-black?style=for-the-badge&logo=java&logoColor=white
[java-url]: https://www.oracle.com/java/
[rabbitmq.com]: https://img.shields.io/badge/RabbitMQ-black?style=for-the-badge&logo=rabbitmq&logoColor=white
[rabbitmq-url]: https://www.rabbitmq.com/
[swagger.com]: https://img.shields.io/badge/Swagger-black?style=for-the-badge&logo=swagger&logoColor=white
[swagger-url]: https://swagger.io/
[postgresql.com]: https://img.shields.io/badge/PostgreSQL-black?style=for-the-badge&logo=postgresql&logoColor=white
[postgresql-url]: https://www.postgresql.org/
