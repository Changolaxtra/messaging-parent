package dan.rojas.epam.rest.controller;

import dan.rojas.epam.dto.Event;
import dan.rojas.epam.service.EventServiceDb;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/events")
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Student Entity!!!!")
public class EventServiceController {

  private final EventServiceDb eventServiceDb;

  @GetMapping
  @ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
  public List<Event> getAllEvents() {
    return eventServiceDb.getAllEvents();
  }

  @GetMapping("/{id}")
  public Event getEvent(@PathVariable final Long id) {
    return eventServiceDb.getEvent(id);
  }

  @DeleteMapping("/{id}")
  public Event deleteEvent(@PathVariable final Long id) {
    return eventServiceDb.deleteEvent(id);
  }

  @PostMapping
  public Event saveEvent(@RequestBody final Event event) {
    return eventServiceDb.createEvent(event);
  }

  @PutMapping
  public Event updateEvent(@RequestBody final Event event) {
    return eventServiceDb.updateEvent(event.getEventId(), event);
  }
}
