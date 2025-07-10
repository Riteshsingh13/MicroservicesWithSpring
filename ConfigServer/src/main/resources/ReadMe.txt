Setting up a Spring Cloud Config Server named ConfigServer that serves configuration files from a GitHub repository.

@EnableConfigServer: This enables Spring Cloud Config Server functionality, 
allowing it to serve centralized config to client apps from a backend source (GitHub in our case).


spring.cloud.config.server.git.uri=https://github.com/Riteshsingh13/eureka-config-server
spring.cloud.config.server.git.clone-on-start=true

This points the config server to a Git repository which contains your externalized config files.
It supports .properties or .yml files for each service (e.g. ProductService.yml, OrderService.properties, etc.).
clone-on-start=true: Clones the Git repo every time the config server starts.


This configures the config server as a Eureka client.
prefer-ip-address=true: Uses the machine's IP address instead of hostname when registering with Eureka.
register-with-eureka=true: Enables registration with Eureka.
fetch-registry=true: Enables fetching registry info from Eureka (optional for config server).
defaultZone=http://localhost:2580/eureka: Points to your Eureka server running on port 2580.


How It Works (Flow)

At startup:
The Config Server starts on port 2579.
It clones the Git repo https://github.com/Riteshsingh13/eureka-config-server.
It registers itself with Eureka at http://localhost:2580/eureka.

Config Clients (e.g., ProductService)
Use spring.config.import=configserver:http://localhost:2579
On startup, they ask the Config Server:
GET http://localhost:2579/ProductService/default
Config Server returns properties from ProductService.yml or .properties.



