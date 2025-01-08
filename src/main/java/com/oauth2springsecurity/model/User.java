package com.oauth2springsecurity.model;

import lombok.Data;

@Data
public class User {

  private String name;
  private String email;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
