package edu.wgu.d387_sample_code.assessment;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class WelcomeController {

    @RequestMapping(path = "/presentation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessage(){

        ShowMessage showMessage = new ShowMessage();

        String [] arrayMessages = showMessage.getWelcomeMessage();

        return arrayMessages[0] + " " + arrayMessages[1];

    }

}
