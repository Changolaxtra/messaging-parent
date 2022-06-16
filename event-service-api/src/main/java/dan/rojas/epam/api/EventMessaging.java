package dan.rojas.epam.api;

import dan.rojas.epam.dto.Event;

public interface EventMessaging {
  void createEvent(Event event);
  void updateEvent(Event event);
  void deleteEvent(Long id);
}
