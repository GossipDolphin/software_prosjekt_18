package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softwareengineering.model.Arrangement;

@Controller
 public class indexController {
    @GetMapping("/")
    public String arrangementer(Model model){
        model.addAttribute("arrangementer", Arrangement.getAlleArrangement());
        return "index.html";
    }
}
