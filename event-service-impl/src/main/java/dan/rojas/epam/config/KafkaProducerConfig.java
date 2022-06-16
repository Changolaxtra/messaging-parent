package dan.rojas.epam.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Data
@Configuration
@Profile("kafka")
public class KafkaProducerConfig {

  @Value("${topic.create-event}")
  private String createTopicName;

  @Value("${topic.update-event}")
  private String updateTopicName;

  @Value("${topic.delete-event}")
  private String deleteTopicName;

  @Value("${spring.kafka.producer.bootstrap-servers}")
  private String server;

}
