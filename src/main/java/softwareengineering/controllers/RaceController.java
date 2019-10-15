package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import softwareengineering.model.Bruker;
import softwareengineering.utilities.BrukerCookieUtility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RaceController {
BrukerCookieUtility brukerCookieUtility = new BrukerCookieUtility();
    @GetMapping("/race")
        public String readCookie(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            Bruker brukertemp = null;
            for (Cookie cookie : cookies) {
                brukertemp = brukerCookieUtility.checkCookie(cookie);

            }


        }
        catch (Exception e){
            System.out.println(e);
        }
        return "e";
    }

}
