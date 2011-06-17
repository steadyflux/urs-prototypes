package com.raytheon.eosdis.urs.service;

import org.springframework.stereotype.Service;

@Service
public class HelloSoapResourceServiceImpl implements HelloSoapResourceService {
  public void authenticate(String name, String password) {
      System.out.print("Authentication: [" + name + "][" + password + "]");
  }
}