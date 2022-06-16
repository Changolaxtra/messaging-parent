package dan.rojas.epam.messaging.config;

import lombok.RequiredArgsConstructor;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@Profile("active")
@RequiredArgsConstructor
public class ActiveConnectionConfig {

  private final ActiveConfig activeConfig;

  @Bean
  public ActiveMQConnectionFactory connectionFactory() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    connectionFactory.setBrokerURL(activeConfig.getBrokerUrl());
    connectionFactory.setPassword(activeConfig.getActivePassword());
    connectionFactory.setUserName(activeConfig.getActiveUser());
    connectionFactory.setTrustAllPackages(true);
    return connectionFactory;
  }

  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory());
    factory.setConcurrency("1-1");
    return factory;
  }

}
