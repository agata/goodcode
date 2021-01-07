package goodcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(nameGenerator = FQCNGenerator.class)
public class Goodcode06Application {

	public static void main(String[] args) {
		SpringApplication.run(Goodcode06Application.class, args);
	}

}
