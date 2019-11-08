package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import softwareengineering.model.Bruker;
import softwareengineering.utilities.BrukerCookieUtility;

import javax.servlet.http.HttpServletResponse;

@Controller
public class SignupController {
    @GetMapping("/signup")
    public String signup(){
        return "signup.html";
    }

    BrukerCookieUtility bcu = new BrukerCookieUtility();
    @RequestMapping(value = "/signup")
    public RedirectView signupInput(@RequestParam("bruker") String bruker, @RequestParam("password") String password, @RequestParam(value = "navn",required = false) String navn,@RequestParam(value = "fornavn", required = false)
            String fornavn,@RequestParam(value = "etternavn", required = false) String etternavn, HttpServletResponse response, Model model) throws Exception {

        try {
           Bruker temp = Bruker.registrerBruker(bruker.toLowerCase(), password, fornavn, etternavn, navn);
            if(temp != null) {
                response.addCookie(bcu.BrukerCookie(temp));
            }
        }
        catch (NullPointerException e){
            System.out.println(e.toString());
        }
        return new RedirectView("arrangementer");
    }
}
