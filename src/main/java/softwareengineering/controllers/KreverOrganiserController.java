package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KreverOrganiserController {
    @GetMapping("kreverorganiser")
    public String kreverOrganiser(Model model){
        return "kreverorganiser.html";
    }
}
