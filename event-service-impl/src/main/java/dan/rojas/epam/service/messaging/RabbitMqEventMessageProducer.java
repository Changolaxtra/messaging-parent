package dan.rojas.epam.service.messaging;

import dan.rojas.epam.api.EventMessageProducer;
import dan.rojas.epam.config.RabbitMqProducerConfig;
import dan.rojas.epam.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("rabbit")
@RequiredArgsConstructor
public class RabbitMqEventMessageProducer implements EventMessageProducer {

  private final RabbitTemplate rabbitTemplate;
  private final RabbitMqProducerConfig rabbitMqProducerConfig;

  @Override
  public void createEvent(Event event) {
    log.info("Sending to Rabbit queue {}", rabbitMqProducerConfig.getCreateQueueName());
    rabbitTemplate.convertAndSend(rabbitMqProducerConfig.getCreateQueueName(), event);
  }

  @Override
  public void updateEvent(Event event) {
    log.info("Sending to Rabbit queue {}", rabbitMqProducerConfig.getUpdateQueueName());
    rabbitTemplate.convertAndSend(rabbitMqProducerConfig.getUpdateQueueName(), event);
  }

  @Override
  public void deleteEvent(Event event) {
    log.info("Sending to Rabbit queue {}", rabbitMqProducerConfig.getUpdateQueueName());
    rabbitTemplate.convertAndSend(rabbitMqProducerConfig.getUpdateQueueName(), event);
  }
}
