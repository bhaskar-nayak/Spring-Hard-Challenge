package Challange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@ComponentScan("com.Challange")
@EntityScan(basePackages = {"com.Challange.model"})
@EnableTransactionManagement
@SpringBootApplication
public class ChallangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallangeApplication.class, args);
	}

}
