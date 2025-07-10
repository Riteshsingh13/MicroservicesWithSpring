Spring Boot microservice (ProductService) that connects to a MySQL database, 
exposes Actuator endpoints for monitoring (including Prometheus), and fetches configuration from a Spring Cloud Config Server.

spring.config.import=configserver:http://localhost:2579
-Tells Spring Boot to import configuration from a Spring Cloud Config Server running at http://localhost:2579

At startup, Spring fetches config for ProductService from the config server (usually stored in Git or a local repo).

It looks for a file like:
productservice.properties  
productservice.yml  
application.yml  

If the config server is down, the application will fail to start (unless spring.cloud.config.fail-fast=false is set).