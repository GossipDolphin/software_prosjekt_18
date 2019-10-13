package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import softwareengineering.model.Arrangement;

@Controller
public class ArrangementsController {
    @GetMapping("/arrangementer")
    public String arrangementer(Model model){
        model.addAttribute("arrangementer", Arrangement.getAlleArrangement());
        return "arrangementer.html";
    }
}
