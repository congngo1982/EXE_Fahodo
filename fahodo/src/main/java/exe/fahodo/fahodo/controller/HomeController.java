package exe.fahodo.fahodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String HomePage(){
        return "index.html";
    }

    @GetMapping("/login")
    public String LoginPage(){
        return "signin.html";
    }

}
