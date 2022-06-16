package dan.rojas.epam.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@Jacksonized
public class EventError {
  private int errorCode;
  private String message;
}
