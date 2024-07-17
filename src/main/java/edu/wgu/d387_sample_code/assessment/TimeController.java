package edu.wgu.d387_sample_code.assessment;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class TimeController {

    @RequestMapping(path = "/timezones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTimezones(){

        TimezoneConverter timezoneConverter = new TimezoneConverter();

        return timezoneConverter.getTimezones();

    }

}
