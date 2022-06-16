package dan.rojas.epam.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("dan.rojas.epam.*")
@EnableJpaRepositories({"dan.rojas.epam.*"})
@ComponentScan({"dan.rojas.epam.*"})
public class EventServiceRestApplication {

  public static void main(String[] args) {
    SpringApplication.run(EventServiceRestApplication.class, args);
  }

}
