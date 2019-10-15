package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RaceController {

    @GetMapping("/race")
        public String readCookie(@CookieValue(value = "name", defaultValue = "Atta") String username) {
            return "Hey! My username is " + username;


    }
}
