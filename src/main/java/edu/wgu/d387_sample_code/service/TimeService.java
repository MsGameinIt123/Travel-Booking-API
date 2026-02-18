package edu.wgu.d387_sample_code.service;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {
    public String getPresentationTimes() {
        // Assume presentation time is now in Eastern Time
        ZonedDateTime etTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        //Convert to Mountain Time
        ZonedDateTime mtTime = etTime.withZoneSameInstant((ZoneId.of("America/Denver")));

        //Convert to UTC
        ZonedDateTime utcTime = etTime.withZoneSameInstant((ZoneId.of("UTC")));

        //Format as hours and minutes
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("HH:mm"));

        return "Live Presentation Time:<br>" +
                "ET: " + etTime.format(formatter) + "<br>" +
                "MT: " + mtTime.format(formatter) + "<br>" +
                "UTC: " + utcTime.format(formatter);
    }
}
