package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import softwareengineering.model.Bruker;
import softwareengineering.model.Deltager;
import softwareengineering.model.Organiser;
import softwareengineering.utilities.BrukerCookieUtility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SignupController {
    @GetMapping("/signup")
    public String signup(){
        return "signup.html";
    }

    BrukerCookieUtility bcu = new BrukerCookieUtility();
    @RequestMapping(value = "/signup")
    public RedirectView signupInput(@RequestParam("bruker") String bruker, @RequestParam("password") String password, @RequestParam(value = "navn",required = false) String navn,@RequestParam(value = "fornavn", required = false)
            String fornavn,@RequestParam(value = "etternavn", required = false) String etternavn, HttpServletResponse response, Model model) throws IOException {

        Cookie cooks = new Cookie("test","test");
        //Bruker temp = Bruker.login(bruker,password);
        Bruker temp = null;
        System.out.println(navn);
        System.out.println(fornavn);
        System.out.println(etternavn);
        if(navn != null)
            temp = new Organiser(bruker,password,navn);
        if(fornavn != null && etternavn!=null)
            temp = new Deltager(bruker,password,fornavn,etternavn);
        if(temp != null)
        System.out.println(temp.getNavn() + " signed up");
        if(temp!=null)
            response.addCookie(bcu.BrukerCookie(temp));
        return new RedirectView("login");
    }
}
