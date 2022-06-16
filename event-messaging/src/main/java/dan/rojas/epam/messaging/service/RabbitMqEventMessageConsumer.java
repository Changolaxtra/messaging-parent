package dan.rojas.epam.messaging.service;

import dan.rojas.epam.api.EventMessageConsumer;
import dan.rojas.epam.dto.Event;

import java.util.List;

public class RabbitMqEventMessageConsumer implements EventMessageConsumer {
  @Override
  public void createEvent(List<Event> events) {

  }

  @Override
  public void updateEvent(List<Event> events) {

  }

  @Override
  public void deleteEvent(List<Event> eventIds) {

  }
}
