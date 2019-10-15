package softwareengineering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import softwareengineering.model.Bruker;
import softwareengineering.utilities.BrukerCookieUtility;

import javax.servlet.http.Cookie;
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
    public String loginInput(@RequestParam("bruker") String bruker, @RequestParam("password") String password, HttpServletResponse response, Model model) throws IOException {
        Cookie cooks = new Cookie("test","test");
        Bruker temp = Bruker.login(bruker,password);
        System.out.println(temp.getNavn() + " logged in");
        if(temp!=null)
            response.addCookie(bcu.BrukerCookie(temp));
        return "login.html";
    }
}
