package dan.rojas.epam.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "eventId")
public class Event {
  @Id
  private Long eventId;
  private String title;
  private String place;
  private String speaker;
  private EventType eventType;
  private LocalDateTime dateTime;
}
