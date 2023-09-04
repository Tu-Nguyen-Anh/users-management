package com.example.demo.exception.advice;

import com.example.demo.dto.response.ResponseGeneral;
import com.example.demo.exception.*;
import com.example.demo.exception.Error;
import com.example.demo.exception.base.BaseException;
import com.example.demo.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;
import java.util.Map;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class UserExceptionHandler {
  private final MessageSource messageSource;
  private final MessageService messageService;

  @ExceptionHandler(value = {BaseException.class})
  public ResponseEntity<ResponseGeneral<Error>> handleBaseException(
        BaseException ex,
        WebRequest webRequest
  ) {
    return ResponseEntity
          .status(ex.getStatus())
          .body(getError(ex, webRequest.getLocale()));
  }

  private ResponseGeneral<Error> getError(BaseException ex, Locale locale) {
    String code = ex.getCode();
    String message;
    if (ex instanceof UserNotFoundException) {
      String id = ex.getParams().get("id");
      message = "Could not find user with ID " + id;
    } else if (ex instanceof DuplicateUsernameException) {
      String username = ex.getParams().get("username");
      message = "Duplicate Username " + username;
    } else {
      message = getMessage(code, ex.getParams(), locale);
    }
    Error error = Error.of(code, message);

    String errorMessage;
    if (ex instanceof UserNotFoundException) {
      errorMessage = "User Not Found";
    } else if (ex instanceof UserCreationException) {
      errorMessage = "Could not create user";
    } else if (ex instanceof UserUpdateException) {
      errorMessage = "Could not update user";
    } else if (ex instanceof DuplicateUsernameException) {
      errorMessage = "Duplicate Username Exception";
    } else {
      errorMessage = "An error has occurred";
    }

    return ResponseGeneral.ofError(
          errorMessage,
          error
    );
  }

  private String getMessage(String code, Map<String, String> params, Locale locale) {
    try {
      String[] paramsArray = new String[params.size()];
      for (int i = 0; i < params.size(); i++) {
        paramsArray[i] = params.get(Integer.toString(i));
      }
      return messageSource.getMessage(code, paramsArray, locale);
    } catch (Exception ex) {
      return code;
    }
  }
}