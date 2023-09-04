//package com.example.demo.dto.response;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import lombok.Data;
//import org.springframework.http.HttpStatus;
//
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@Data
//public class ResponseGeneral<T> {
//
//  private String message;
//  private int statusCode;
//  private T data;
//
//  public ResponseGeneral(String message, T data, int statusCode) {
//    this.message = message;
//    this.statusCode = statusCode;
//    this.data = data;
//  }
//  public ResponseGeneral(String message) {
//    this.message = message;
//  }
//
//  public static <T> ResponseGeneral<T> of(String message, T data, int statusCode) {
//    return new ResponseGeneral<>(message, data, statusCode);
//  }
//  public static <T> ResponseGeneral<T> ofCreated(String message, T data) {
//    return new ResponseGeneral<>(message, data, HttpStatus.CREATED.value());
//  }
//}
package com.example.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseGeneral<T> {

  private String status;
  private String message;
  private T data;

  public ResponseGeneral(String status, String message, T data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public static <T> ResponseGeneral<T> ofSuccess(String message, T data) {
    return new ResponseGeneral<>("success", message, data);
  }

  public static <T> ResponseGeneral<T> ofError(String message, T data) {
    return new ResponseGeneral<>("error", message, data);
  }
}
