package kk.springframework.springmvc;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringmvcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringmvcApplication.class, args);

		System.out.println("Beans ************");
		System.out.println(context.getBeanDefinitionCount());
		Arrays.asList(context.getBeanDefinitionNames()).stream().forEach(System.out::println);
	}
}
