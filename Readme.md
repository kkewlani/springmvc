# springmvc
spring framework tutorial on springmvc

## Notes
Few things to note while working on JPA stuff in this project:
1. You will have to import `spring-boot-devtools` jar ni the maven dependency in pom.xml in order to make the h2-console 
work, or will have to manually write the configuration for h2. The sample has been added in this package. java class:
`WebConfiguration.java` with commented code. It seems that it should have `spring boot auto-configure` in order to make 
it work. However, this jar is already included with `spring-boot-starter` but still was not working unless 
added/specified explicitly. 
    1. I tried removing the `spring-boot-devtools` once after adding it once, in order to check if there is some issue 
    with maven local repository in loading these jars at runtime. But it still did not work even though that jar is 
    included in as sub jar of `spring-boot-starter`. So I had to add it again in order to make it work.     
1. The **jdbcUrl** to be used for default configuration is `jdbc:h2:mem:testdb` and not `jdbc:h2:~/test` which is the 
default when console loads.  
1. While using JPA with `versioning` for optimistic locking (the default mechanism used by JPA), we'll have to specify 
the version being passed in the html form while editing an object in order for JPw to understand that it is an edit, 
otherwise it will create a new object every time an object is edited. 
