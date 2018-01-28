# springmvc
spring framework tutorial on springmvc

## Notes
Few things to note while working on JPA stuff in this project:
1. You will have to import `spring-boot-devtools` jar ni the maven dependency in pom.xml in order to make the h2-console 
work, or will have to manually write the configuration for h2. The sample has been added in this package. java class:
`WebConfiguration.java` with commented code. It seems that it should have `spring boot auto-configure` in order to make 
it work. However, this jar is already included with `spring-boot-starter` but still was not working unless 
added/specified explicitly. 
2. The **jdbcUrl** to be used for default configuration is `jdbc:h2:mem:testdb` and not `jdbc:h2:~/test` which is the 
default when console loads.  
