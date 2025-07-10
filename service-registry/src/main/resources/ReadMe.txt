Spring Boot application that uses Eureka Server for service discovery in a microservices architecture.
This setup is for a standalone Eureka Server, which will act as a central registry for microservices in your architecture.
(Other microservices (clients) will register themselves with this server discover each other via this registry)

@SpringBootApplication
This is a combination of:

@Configuration – allows us to register extra beans in the context and make it as a config class.
@EnableAutoConfiguration – tells Spring Boot to start adding beans based on classpath settings.
@ComponentScan – looks for components, configurations, and services in the package.

@EnableEurekaServer
This makes the application a Eureka Server, which acts as a service registry.

SpringApplication.run(...)
Bootstraps the application and starts the embedded server (e.g., Tomcat).

✅ spring.application.name=service-registry
Sets the name of the application.
Useful in Spring Cloud for identifying the service when other services register with Eureka.

✅ server.port=2580
Changes the default port from 8080 to 2580.
This is the port where your Eureka Server will be available (i.e., http://localhost:2580).

✅ eureka.instance.hostname=localhost
Sets the hostname for Eureka's registration URLs and instance info.
This is typically used when running on a host with multiple IPs or in cloud environments.

✅ eureka.client.register-with-eureka=false
This disables the registration of this application as a client to Eureka.
Since this is a Eureka server, it should not try to register itself.

✅ eureka.client.fetch-registry=false
This tells the Eureka server not to fetch registry data from other Eureka servers.
Again, since it's acting as a standalone Eureka server, it doesn't need to fetch data.
