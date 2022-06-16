package dan.rojas.epam.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@Jacksonized
@ToString
public class Event implements Serializable {
  private Long eventId;
  private String title;
  private String place;
  private String speaker;
  private EventType eventType;
  private LocalDateTime dateTime;
}
