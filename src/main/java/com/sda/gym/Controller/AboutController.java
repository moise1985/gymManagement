package com.sda.gym.Controller;

import com.sda.gym.Entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/about")
public class AboutController {

    @GetMapping("/list")
    public String viewPage(){

        return "about";
    }


}
