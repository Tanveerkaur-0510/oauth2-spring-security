package com.oauth2springsecurity.service;

import com.oauth2springsecurity.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public User createUser(@NotNull OAuth2User oAuth2User) {
    User user = new User();
    // Set user attributes from OAuth2User
    user.setName(oAuth2User.getAttribute("login"));
    user.setEmail(oAuth2User.getAttribute("email"));
    return user;
  }
}
