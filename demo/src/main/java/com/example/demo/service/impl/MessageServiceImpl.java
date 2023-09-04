package com.example.demo.service.impl;

import com.example.demo.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
  private final MessageSource messageSource;

  @Override
  public String getMessage(String code, Object[] args, Locale locale) {
    try {
      return messageSource.getMessage(code, args, locale);
    } catch (Exception ex) {
      return code;
    }
  }
}
