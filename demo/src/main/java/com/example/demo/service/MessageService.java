package com.example.demo.service;

import java.util.Locale;

public interface MessageService {
  String getMessage(String code, Object[] args, Locale locale);
}
