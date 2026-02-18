package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/presentation-times")
    public String getTimes() {
        return timeService.getPresentationTimes();
    }
}
