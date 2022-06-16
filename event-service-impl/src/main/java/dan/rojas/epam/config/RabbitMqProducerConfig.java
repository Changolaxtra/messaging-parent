package dan.rojas.epam.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Data
@Configuration
@Profile("rabbit")
public class RabbitMqProducerConfig {

  @Value("${queue.create-event}")
  private String createQueueName;

  @Value("${queue.update-event}")
  private String updateQueueName;

  @Value("${queue.delete-event}")
  private String deleteQueueName;
}
