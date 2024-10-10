package com.mytests.spring.springschedulednonreactive;

import com.mytests.spring.springschedulednonreactive.methods.ScheduledMethods;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {

    private final ScheduledMethods scheduledMethods;

    public MyController(ScheduledMethods scheduledMethods) {
        this.scheduledMethods = scheduledMethods;
    }

    @GetMapping("/test1")
    public String test1() {
        System.out.println("----");
        return "test1: "+scheduledMethods.getFoo();
    }


}
