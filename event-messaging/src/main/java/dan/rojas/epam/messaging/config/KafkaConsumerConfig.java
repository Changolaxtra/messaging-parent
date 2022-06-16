package dan.rojas.epam.messaging.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Data
@Configuration
@Profile("kafka")
public class KafkaConsumerConfig {

  @Value("${spring.kafka.consumer.bootstrap-servers}")
  private String server;

}
