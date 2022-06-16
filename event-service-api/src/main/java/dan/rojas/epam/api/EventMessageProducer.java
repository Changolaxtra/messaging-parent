package dan.rojas.epam.api;

import dan.rojas.epam.dto.Event;

public interface EventMessageProducer {
  void createEvent(Event event);
  void updateEvent(Event event);
  void deleteEvent(Event event);
}
