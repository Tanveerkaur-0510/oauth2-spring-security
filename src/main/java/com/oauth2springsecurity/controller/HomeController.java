package com.oauth2springsecurity.controller;

import com.oauth2springsecurity.model.User;
import com.oauth2springsecurity.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
  @Autowired
  private UserService userService;

  @GetMapping("/home")
  public ModelAndView home(@AuthenticationPrincipal @NotNull OAuth2User principal) {
    // Add user name to the model
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.setViewName("home");
    modelAndView.addObject("name", principal.getAttribute("login"));
    User user =userService.createUser(principal);
    return modelAndView;
  }

  @GetMapping("/login")
  public ModelAndView login() {
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.setViewName("login");
    return modelAndView;
  }

}
