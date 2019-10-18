package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginfeiletController {
    @GetMapping("loginfeilet")
    public String loginfeilet(Model model){
        return "loginfeilet.html";
    }
}
