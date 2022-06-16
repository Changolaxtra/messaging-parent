package dan.rojas.epam.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Jacksonized
@ToString
public class Event {
  private Long eventId;
  private String title;
  private String place;
  private String speaker;
  private EventType eventType;
  private LocalDateTime dateTime;
}
