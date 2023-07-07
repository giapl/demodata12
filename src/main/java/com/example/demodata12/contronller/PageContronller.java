package com.example.demodata12.contronller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PageContronller {

  @GetMapping("/admin")
  public String PageAdmin() {
    return "Hello page admin";
  }

  @GetMapping("/home")
  public String PageUser() {
    return "Hello page";
  }
}
