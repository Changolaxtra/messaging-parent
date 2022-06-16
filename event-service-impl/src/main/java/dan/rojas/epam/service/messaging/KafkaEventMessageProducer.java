package dan.rojas.epam.service.messaging;

import dan.rojas.epam.api.EventMessageProducer;
import dan.rojas.epam.config.KafkaProducerConfig;
import dan.rojas.epam.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("kafka")
@RequiredArgsConstructor
public class KafkaEventMessageProducer implements EventMessageProducer {

  private final KafkaTemplate<String, Event> eventKafkaTemplate;
  private final KafkaProducerConfig kafkaProducerConfig;

  @Override
  public void createEvent(Event event) {
    log.info("Sending to kafka topic {}...", kafkaProducerConfig.getCreateTopicName());
    eventKafkaTemplate.send(kafkaProducerConfig.getCreateTopicName(), event);
  }

  @Override
  public void updateEvent(Event event) {
    log.info("Sending to kafka topic {}...", kafkaProducerConfig.getUpdateTopicName());
    eventKafkaTemplate.send(kafkaProducerConfig.getUpdateTopicName(), event);
  }

  @Override
  public void deleteEvent(Event event) {
    log.info("Sending to kafka topic {}...", kafkaProducerConfig.getDeleteTopicName());
    eventKafkaTemplate.send(kafkaProducerConfig.getDeleteTopicName(), event);
  }
}
