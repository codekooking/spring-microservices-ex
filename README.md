# Spring Microservices
This is Backend Development repository for [Simple Exchange Service](https://github.com/orgs/codekooking/projects/2) project.

This repository demonstrates [Microservice Architecture Pattern](https://martinfowler.com/microservices/) using [Spring Boot](https://spring.io/projects/spring-boot), [Spring Cloud](http://cloud.spring.io/), [Docker](https://www.docker.com/) and some other awesome techniques.

### Building Docker images
By running the following command, Maven will execute the **Spotify docker plugin** defined in the pom.xml file.

``
$ mvn clean package docker:build
``

### Running the services
Now we are going to use **docker-compose** to start the actual image. To start the docker image, running the following docker-compose command:

``$ docker-compose -f docker/common/docker-compose.yml up``

If everything starts correctly you should see a bunch of Spring Boot information fly by on standard out. 

### Starting request API
Now you can enjoy the API by import **Postman** script located at `postman/first-spring-boot.json`