package dan.rojas.epam.messaging.service;

import dan.rojas.epam.api.EventMessageConsumer;
import dan.rojas.epam.dto.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Profile("kafka")
public class KafkaEventMessageConsumer implements EventMessageConsumer {

  @Override
  @KafkaListener(topics = "${topic.create-event}", groupId = "${spring.kafka.consumer.group-id}")
  public void createEvent(List<Event> events) {
    log.info("Consumer -> Created Events: {}", events);
  }

  @Override
  @KafkaListener(topics = "${topic.update-event}", groupId = "${spring.kafka.consumer.group-id}")
  public void updateEvent(List<Event> events) {
    log.info("Consumer -> Updated Events: {}", events);
  }

  @Override
  @KafkaListener(topics = "${topic.delete-event}", groupId = "${spring.kafka.consumer.group-id}")
  public void deleteEvent(List<Event> events) {
    log.info("Consumer -> Deleted Events: {}", events);
  }
}
