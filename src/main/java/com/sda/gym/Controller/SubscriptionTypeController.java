package com.sda.gym.Controller;

import com.sda.gym.Entity.Subscription;
import com.sda.gym.Entity.SubscriptionType;
import com.sda.gym.Service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subscriptionType")
public class SubscriptionTypeController {

    @Autowired
    private SubscriptionTypeService subscriptionTypeService;

    @GetMapping("/list")
    public String subscriptionTypeList(Model model){
        List<SubscriptionType> list = subscriptionTypeService.getAll();
        model.addAttribute("subscriptionTypeList", list );
        model.addAttribute("subscriptionType", new SubscriptionType());
        return "subscriptionTypeList";
    }

    @PostMapping({"/delete/{id}"})
    public String delete (@PathVariable int id) {
        this.subscriptionTypeService.delete(id);
        return "redirect:/subscriptionType/list";
    }

    @PostMapping({"/save"})
    public String save (@ModelAttribute SubscriptionType subscriptionType){
        this.subscriptionTypeService.add(subscriptionType);
        return "redirect:/subscription/list";
    }




}
