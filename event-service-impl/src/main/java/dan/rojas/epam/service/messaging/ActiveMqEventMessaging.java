package dan.rojas.epam.service.messaging;

import dan.rojas.epam.api.EventMessaging;
import dan.rojas.epam.dto.Event;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("active")
public class ActiveMqEventMessaging implements EventMessaging {
  @Override
  public void createEvent(Event event) {

  }

  @Override
  public void updateEvent(Event event) {

  }

  @Override
  public void deleteEvent(Long id) {

  }
}
