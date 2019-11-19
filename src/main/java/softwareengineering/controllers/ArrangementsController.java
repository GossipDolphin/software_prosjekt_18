package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import softwareengineering.model.Arrangement;
import softwareengineering.model.Bruker;
import softwareengineering.model.Organiser;
import softwareengineering.model.Race;
import softwareengineering.utilities.BrukerCookieUtility;
import softwareengineering.utilities.GoogleMapsApi;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
public class ArrangementsController {
    GoogleMapsApi api = new GoogleMapsApi();

    @GetMapping("/arrangementer")
    public String arrangementer(Model model){
        model.addAttribute("arrangementer", Arrangement.alleArrangement);
        return "arrangementer.html";
    }
    @GetMapping("/arrangementer/{id}")
    public String arrangement(@PathVariable String id, Model model){
        int parsedId = Integer.parseInt(id);
        model.addAttribute("arrangement", Arrangement.getArrangementById(parsedId));
        model.addAttribute("mapsurl", api.getUrl(Arrangement.getArrangementById(parsedId).getLokasjon()));
        return "arrangement.html";
    }

    @RequestMapping(value = "/arrangementer")
    public RedirectView ArrangementInput(@RequestParam("navn") String navn, @RequestParam("beskrivelse") String beskrivelse, @RequestParam(value = "startTid") String startTid, @RequestParam(value = "sluttTid")
            String slutttid, @RequestParam(value = "lokasjon") String lokasjon, HttpServletRequest request, Model model) throws IOException {

        LocalDateTime startTidformatted = LocalDateTime.parse(startTid);
        LocalDateTime sluttTtidformatted = LocalDateTime.parse(slutttid);

       Bruker user = BrukerCookieUtility.opprettBrukerFraCookie(request);
        if (user instanceof Organiser){
            Organiser organiser = (Organiser) user;
            Arrangement arrangement = new Arrangement(navn,beskrivelse,startTidformatted,sluttTtidformatted,lokasjon, organiser);
        }
        else {
            return new RedirectView("/kreverorganiser");
        }
        return new RedirectView("arrangementer");
    }

    @RequestMapping(value = "/arrangementer/{id}")
    public RedirectView opprettRace(@PathVariable String id, @RequestParam("navn") String navn, @RequestParam("beskrivelse") String beskrivelse, @RequestParam(value = "startTid") String startTid, @RequestParam(value = "sluttTid")
            String slutttid, HttpServletRequest request, Model model) throws IOException{
        int parsedId = Integer.parseInt(id);
        LocalDateTime startTidParsed = LocalDateTime.parse(startTid);
        LocalDateTime sluttTidParsed = LocalDateTime.parse(slutttid);
        Arrangement arrangementet = Arrangement.getArrangementById(parsedId);
        Bruker user = BrukerCookieUtility.opprettBrukerFraCookie(request);

        if (user!= arrangementet.getOrganiser()){
            return new RedirectView("/kreverorganiser");
        }
        if (user.equals(arrangementet.getOrganiser())) {
            Race race = new Race(navn, beskrivelse, startTidParsed, sluttTidParsed, arrangementet);
            return new RedirectView("/arrangementer/{id}");
        }
        else {
            return new RedirectView("/kreverorganiser");
        }
    }
}
