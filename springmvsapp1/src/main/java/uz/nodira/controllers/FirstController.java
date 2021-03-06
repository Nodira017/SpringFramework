package uz.nodira.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String hello(){
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "first/goodbye";
    }
}
