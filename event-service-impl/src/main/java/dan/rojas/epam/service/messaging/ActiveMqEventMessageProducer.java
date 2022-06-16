package dan.rojas.epam.service.messaging;

import dan.rojas.epam.api.EventMessageProducer;
import dan.rojas.epam.config.ActiveConfig;
import dan.rojas.epam.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("active")
@RequiredArgsConstructor
public class ActiveMqEventMessageProducer implements EventMessageProducer {

  private final JmsTemplate jmsTemplate;
  private final ActiveConfig activeConfig;

  @Override
  public void createEvent(Event event) {
    log.info("Sending to Rabbit queue {}", activeConfig.getCreateTopicName());
    jmsTemplate.convertAndSend(activeConfig.getCreateTopicName(), event);
  }

  @Override
  public void updateEvent(Event event) {
    log.info("Sending to Rabbit queue {}", activeConfig.getUpdateTopicName());
    jmsTemplate.convertAndSend(activeConfig.getUpdateTopicName(), event);
  }

  @Override
  public void deleteEvent(Event event) {
    log.info("Sending to Rabbit queue {}", activeConfig.getDeleteTopicName());
    jmsTemplate.convertAndSend(activeConfig.getDeleteTopicName(), event);
  }
}
