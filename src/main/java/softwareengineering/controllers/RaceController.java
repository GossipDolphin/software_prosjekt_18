package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import softwareengineering.model.Bruker;
import softwareengineering.model.Deltager;
import softwareengineering.model.Race;
import softwareengineering.utilities.BrukerCookieUtility;

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
    public RedirectView readCookie(@PathVariable String raceId,HttpServletRequest request, Model model) {
        int parsedRaceId = Integer.parseInt(raceId);
        model.addAttribute("race", Race.getRaceById(parsedRaceId));
        Bruker brukertemp = BrukerCookieUtility.opprettBrukerFraCookie(request);

        if(brukertemp instanceof Deltager) {
            Deltager temp = (Deltager)brukertemp;
            Race.getRaceById(parsedRaceId).getDeltagere().add(temp);
            return new RedirectView("/race/{raceId}");
        }
        else {
            return new RedirectView("/kreverdeltager");
        }
    }
}
