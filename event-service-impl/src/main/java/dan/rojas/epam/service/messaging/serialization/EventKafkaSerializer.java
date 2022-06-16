package dan.rojas.epam.service.messaging.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dan.rojas.epam.dto.Event;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Objects;

public class EventKafkaSerializer implements Serializer<Event> {

  private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

  @Override
  public byte[] serialize(String topic, Event event) {
    try {
      byte[] bytes = null;
      if (Objects.nonNull(event)) {
        bytes = objectMapper.writeValueAsBytes(event);
      }
      return bytes;
    } catch (JsonProcessingException jsonProcessingException) {
      throw new SerializationException("Error when serializing Event to byte[]", jsonProcessingException);
    }
  }

}
