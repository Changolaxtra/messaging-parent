package dan.rojas.epam.api;

import dan.rojas.epam.dto.Event;

import java.util.List;

public interface EventMessageConsumer {
  void createEvent(List<Event> events);
  void updateEvent(List<Event> events);
  void deleteEvent(List<Event> eventIds);
}
