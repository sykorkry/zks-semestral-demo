# ZKS CI/CD showcase project

This project is intended for educational purposes. 
It uses the [spring-petclinic](https://github.com/spring-projects/spring-petclinic)
and the [selenium-starter-kit](https://gitlab.fel.cvut.cz/frajtak/mastering-selenium-testng)
projects.

To run the project use:
```
mvn package --file petclinic/pom.xml
java -jar petclinic/target/petclinic-2.2.2.BUILD-SNAPSHOT.jar
mvn --file petclinic-selenium/pom.xml -DskipTests install
mvn -Dtest=PetclinicTest --file petclinic-selenium/pom.xml -Dbrowser=chrome -Dheadless=false test
```

