package dan.rojas.epam.messaging.config;

import lombok.Data;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class RabbitConfig {

  @Value("${queue.create-event}")
  private String createQueue;

  @Value("${queue.update-event}")
  private String updateQueue;

  @Value("${queue.delete-event}")
  private String deleteQueue;

  @Bean
  public Queue createQueue() {
    return new Queue(createQueue, false);
  }

  @Bean
  public Queue updateQueue() {
    return new Queue(updateQueue, false);
  }

  @Bean
  public Queue deleteQueue() {
    return new Queue(deleteQueue, false);
  }

}
