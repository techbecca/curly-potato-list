package com.curlypotato;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/hello")
public class HelloController {
    
    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
      return "Hello World!";
    }


}
