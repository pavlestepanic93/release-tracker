package com.releasetracker.Releasetracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ReleaseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReleaseTrackerApplication.class, args);
	}
}
