package dan.rojas.epam.messaging.service;

import dan.rojas.epam.api.EventMessageConsumer;
import dan.rojas.epam.dto.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Profile("rabbit")
public class RabbitMqEventMessageConsumer implements EventMessageConsumer {

  @Override
  @RabbitListener(queues = {"${queue.create-event}"})
  public void createEvent(List<Event> events) {
    log.info("Consumer -> Created Events: {}", events);
  }

  @Override
  @RabbitListener(queues = {"${queue.update-event}"})
  public void updateEvent(List<Event> events) {
    log.info("Consumer -> Update Events: {}", events);
  }

  @Override
  @RabbitListener(queues = {"${queue.delete-event}"})
  public void deleteEvent(List<Event> events) {
    log.info("Consumer -> Deleted Events: {}", events);
  }
}
