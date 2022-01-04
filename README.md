# slacker
Slack integration sample

# Development
This is a Spring Boot Application, as such we favor convention over configuration.

## What you'll need
- Git
- Java 1.8+ JDK
- An IDE
  
Once you have cloned this repo, and added the dependencies to your .m2 you should be 
able to build the code using the bundled gradle, for example

`./gradlew clean build`

To deploy the Spring Boot Application, you'll need to configure the 
`config/application-local.properties` file specifying developer environment local values.

Then, to launch the app, select the local profile as the active profile like this:

```
$ java -jar -Dspring.profiles.active=local build/libs/slacker-0.0.1-SNAPSHOT.jar
# or for local development
$ ./gradlew bootRun --args='--spring.profiles.active=local'
```

Logging can be configured externally as well.  For your convenience, you can use
the sample in the config directory to get you going.  For local development, you
can copy in into src/main/resources.  You won't be able to check this file in at this 
location as we explicitly block it from checkin using .gitignore.

## Usage
Visit the host.  Locally, that is http://localhost:8080.
