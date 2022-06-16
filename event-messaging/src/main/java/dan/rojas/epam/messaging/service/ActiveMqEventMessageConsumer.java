package dan.rojas.epam.messaging.service;

import dan.rojas.epam.api.EventMessageConsumer;
import dan.rojas.epam.dto.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Profile("active")
public class ActiveMqEventMessageConsumer implements EventMessageConsumer {

  @Override
  @JmsListener(destination = "${topic.create-event}")
  public void createEvent(List<Event> events) {
    log.info("Consumer -> Created Events: {}", events);
  }

  @Override
  @JmsListener(destination = "${topic.update-event}")
  public void updateEvent(List<Event> events) {
    log.info("Consumer -> Updated Events: {}", events);
  }

  @Override
  @JmsListener(destination = "${topic.delete-event}")
  public void deleteEvent(List<Event> events) {
    log.info("Consumer -> Deleted Events: {}", events);
  }
}
