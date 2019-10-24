package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import softwareengineering.model.Bruker;
import softwareengineering.model.Deltager;
import softwareengineering.model.Race;
import softwareengineering.utilities.BrukerCookieUtility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RaceController {
BrukerCookieUtility brukerCookieUtility = new BrukerCookieUtility();
    @RequestMapping(value = "/race/{raceId}")
        public String showRace(@PathVariable String raceId,HttpServletRequest request, Model model) {
        int parsedRaceId = Integer.parseInt(raceId);
        model.addAttribute("race", Race.getRaceById(parsedRaceId));
        return "Race.html";
    }
    @RequestMapping(value = "/race/{raceId}/join")
    public String readCookie(@PathVariable String raceId,HttpServletRequest request, Model model) {
        int parsedRaceId = Integer.parseInt(raceId);
        model.addAttribute("race", Race.getRaceById(parsedRaceId));
        Bruker brukertemp = null;
            try {
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    brukertemp = brukerCookieUtility.checkCookie(cookie);
                }


            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println("temp" + brukertemp);
        if(brukertemp!=null && brukertemp instanceof Deltager) {
            System.out.println("temp2" + brukertemp);
            Deltager temp = (Deltager)brukertemp;
            temp.joinRace(Race.getRaceById(parsedRaceId)); // har tatt vekk første argument: Race.getRaceById(parsedRaceId).getArrangement(),
        }
        return "Race.html";
    }
}
