package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import softwareengineering.model.Arrangement;
import softwareengineering.utilities.GoogleMapsApi;

@Controller
public class ArrangementsController {
    GoogleMapsApi api = new GoogleMapsApi();

    @GetMapping("/arrangementer")
    public String arrangementer(Model model){
        model.addAttribute("arrangementer", Arrangement.getAlleArrangement());
        return "arrangementer.html";
    }
    @GetMapping("/arrangementer/{id}")
    public String arrangement(@PathVariable String id, Model model){
        int parsedId = Integer.parseInt(id);
        model.addAttribute("arrangement", Arrangement.getArrangementById(parsedId));
        model.addAttribute("mapsurl", api.getUrl(Arrangement.getArrangementById(parsedId).getLokasjon()));
        return "arrangement.html";
    }
}
