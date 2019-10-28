package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import softwareengineering.model.Bruker;
import softwareengineering.utilities.BrukerCookieUtility;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @GetMapping("/login")
            public String login(){
        return "login.html";
    }
    BrukerCookieUtility bcu = new BrukerCookieUtility();
    @RequestMapping(value = "/login")
    public RedirectView loginInput(@RequestParam("bruker") String bruker, @RequestParam("password") String password, HttpServletResponse response, Model model, final RedirectAttributes redirectAttributes) throws IOException {
        try {
            Bruker temp = Bruker.login(bruker, password);
            if (temp != null) {
                response.addCookie(bcu.BrukerCookie(temp));
            }
        }
        catch (Exception e){
            return new RedirectView("loginfeilet");
        }
            return new RedirectView("arrangementer");

    }
}
