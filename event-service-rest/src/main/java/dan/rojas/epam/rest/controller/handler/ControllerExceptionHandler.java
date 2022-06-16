package dan.rojas.epam.rest.controller.handler;

import dan.rojas.epam.dto.EventError;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ResponseBody
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(DataAccessException.class)
  public EventError handleDataAccessException(DataAccessException dataAccessException) {
    return EventError.builder().errorCode(500).message(dataAccessException.getMessage()).build();
  }
}
