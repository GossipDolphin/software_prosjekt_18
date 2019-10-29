package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softwareengineering.model.Bruker;
import softwareengineering.model.Deltager;
import softwareengineering.model.Organiser;
import softwareengineering.utilities.BrukerCookieUtility;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MinSideController {
    @GetMapping("minside")
    public String minside(Model model, HttpServletRequest request){
        Bruker bruker = BrukerCookieUtility.opprettBrukerFraCookie(request);
        if (bruker!=null) {
            model.addAttribute("bruker", bruker.getNavn());
            model.addAttribute("email", bruker.getEmail());
        }
        if (bruker instanceof Deltager){
            Deltager deltager = (Deltager) bruker;
            model.addAttribute("mineRace", deltager.getRaces());
        }
        if (bruker instanceof Organiser){
            Organiser organiser = (Organiser) bruker;
            model.addAttribute("mineArrangement", organiser.getArrangementListe());
        }
        return "minside.html";
    }
}
