package dan.rojas.epam.service.messaging;

import dan.rojas.epam.api.EventMessageProducer;
import dan.rojas.epam.dto.Event;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("rabbit")
public class RabbitMqEventMessageProducer implements EventMessageProducer {
  @Override
  public void createEvent(Event event) {

  }

  @Override
  public void updateEvent(Event event) {

  }

  @Override
  public void deleteEvent(Event event) {

  }
}
