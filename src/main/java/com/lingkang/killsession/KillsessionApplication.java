package com.lingkang.killsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class KillsessionApplication {

  public static void main(String[] args) {
    SpringApplication.run(KillsessionApplication.class, args);
  }

}
