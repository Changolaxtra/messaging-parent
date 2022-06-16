package dan.rojas.epam.messaging.service.deserializer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dan.rojas.epam.dto.Event;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Objects;

public class EventKafkaDeserializer implements Deserializer<Event> {

  private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

  @Override
  public Event deserialize(String topic, byte[] bytes) {
    Event event = null;
    try {
      if (Objects.nonNull(bytes)) {
        event = objectMapper.readValue(bytes, Event.class);
      }
    } catch (Exception e) {
      throw new SerializationException("Error when deserializing byte[] to Event", e);
    }
    return event;
  }

}
