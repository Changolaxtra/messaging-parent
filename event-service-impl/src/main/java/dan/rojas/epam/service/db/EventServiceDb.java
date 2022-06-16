package dan.rojas.epam.service.db;

import dan.rojas.epam.api.EventMessaging;
import dan.rojas.epam.api.EventService;
import dan.rojas.epam.dto.Event;
import dan.rojas.epam.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceDb implements EventService {

  private final EventRepository eventRepository;
  private final EventMessaging eventMessaging;

  @Override
  public Event createEvent(Event event) {
    log.info("Creating event {}...", event);
    eventRepository.save(getAsEntity(event));
    eventMessaging.createEvent(event);
    return event;
  }

  @Override
  public Event updateEvent(Long id, Event event) {
    log.info("Updating event {}", event);
    final Optional<dan.rojas.epam.model.Event> optionalEvent = eventRepository.findById(id);
    if (optionalEvent.isPresent()) {
      event.setEventId(id);
      eventRepository.save(getAsEntity(event));
      eventMessaging.updateEvent(event);
    } else {
      log.info("Event with id {} does not exist", event.getEventId());
      event = null;
    }
    return event;
  }

  @Override
  public Event getEvent(Long id) {
    log.info("Getting event with id {}", id);
    return eventRepository.findById(id)
        .map(this::getAsDto)
        .orElse(null);
  }

  @Override
  public Event deleteEvent(Long id) {
    Event event;
    log.info("Deleting event with id {}", id);
    final Optional<dan.rojas.epam.model.Event> optionalEvent = eventRepository.findById(id);
    if (optionalEvent.isPresent()) {
      event = getAsDto(optionalEvent.get());
      eventRepository.deleteById(id);
      eventMessaging.deleteEvent(id);
    } else {
      log.info("Event with id {} does not exist", id);
      event = null;
    }
    return event;
  }

  @Override
  public List<Event> getAllEvents() {
    return StreamSupport.stream(
            eventRepository.findAll().spliterator(), false)
        .map(this::getAsDto)
        .collect(Collectors.toList());
  }

  private dan.rojas.epam.model.Event getAsEntity(final Event event) {
    final ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(event, dan.rojas.epam.model.Event.class);
  }

  private Event getAsDto(final dan.rojas.epam.model.Event event) {
    final ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(event, Event.class);
  }
}
