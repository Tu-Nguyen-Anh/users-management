package com.example.demo.constant;

public class Message {
  public static final String LOGIN_SUCCESS = "success";

  public static final class ExceptionStatusConstant {
    public static final int CONFLICT = 409;
    public static final int NOT_FOUND = 404;
    public static final int UNAUTHORIZED = 401;
  }

  public static class LanguageConstants {
    public static final String LANGUAGE = "Accept-Language";
    public static final String DEFAULT_LANGUAGE = "en";


  }
  public static class MessageResponse {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String CREATE_SUCCESS = "Create Success";
    public static final String UPDATE_SUCCESS = "Update Success";
    public static final String DELETE_SUCCESS = "Delete Success";
    public static final String LIST_USER = "Get List User Success";
    public static final String LOGIN = "Login Success";
    public static final String GET_BY_USERNAME = "Get By Username Success";
    public static final String GET_BY_ID = "Get By ID Success";
  }

}
