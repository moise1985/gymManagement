package com.sda.gym.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String mainPage() {
        return "redirect:/client/list";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/accessDenied") 
    public String accessDenied()
    {
        return "accessDenied";
    }

    @GetMapping("/unsecured")
    public String unsecured() {
        return "unsecured";
    }

    @GetMapping("/securedAdmin")
    public String securedAdmin() {
        return "securedAdmin";
    }

    @GetMapping("/securedClient")
    public String securedClient() {
        return "securedClient";
    }

}
