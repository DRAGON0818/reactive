package com.example.reactive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author whoami
 */
@RestController
public class GreetingController {
    private static final String word="Hello %s";
    private static AtomicInteger idGenerator=new AtomicInteger();

    @PostMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World") String args){
        return new Greeting(idGenerator.incrementAndGet(), String.format(word,args));
    }

}
