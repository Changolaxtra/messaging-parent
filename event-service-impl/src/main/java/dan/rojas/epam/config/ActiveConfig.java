package dan.rojas.epam.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Data
@Configuration
@Profile("active")
public class ActiveConfig {

  @Value("${spring.activemq.broker-url}")
  private String brokerUrl;

  @Value("${spring.activemq.user}")
  private String activeUser;

  @Value("${spring.activemq.password}")
  private String activePassword;

  @Value("${topic.create-event}")
  private String createTopicName;

  @Value("${topic.update-event}")
  private String updateTopicName;

  @Value("${topic.delete-event}")
  private String deleteTopicName;

}
