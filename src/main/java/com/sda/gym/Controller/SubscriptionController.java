package com.sda.gym.Controller;


import com.sda.gym.Entity.Client;
import com.sda.gym.Entity.Subscription;
import com.sda.gym.Entity.SubscriptionType;
import com.sda.gym.Service.ClientService;
import com.sda.gym.Service.SubscriptionService;
import com.sda.gym.Service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private SubscriptionTypeService subscriptionTypeService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/list/{clientId}")
    public String subscriptionList(Model model, @PathVariable int clientId){
        Client x = clientService.getById(clientId);
        Subscription newSubscription = new Subscription();
        newSubscription.setClient(x);

        model.addAttribute("subscriptionList", x.getSubscriptionList() );
        model.addAttribute("subscription", newSubscription);
        model.addAttribute("subscriptionTypeList", subscriptionTypeService.getAll());
        return "subscriptionList";
    }

    @PostMapping({"/delete/{subscriptionId}"})
    public String delete (@PathVariable int subscriptionId) {
        Subscription s = this.subscriptionService.getById(subscriptionId);
        Client c = s.getClient();

        this.subscriptionService.delete(subscriptionId);

        return "redirect:/subscription/list/" + c.getClientID();
    }

    @PostMapping({"/save"})
    public String save (@RequestParam(required = false) Integer subscriptionID , @RequestParam String startDate, @RequestParam String endDate, @RequestParam int subscriptionTypeId, @RequestParam int clientId){

        Subscription s = new Subscription();

        s.setStartDate(convertStringToDate(startDate));
        s.setEndDate(convertStringToDate(endDate));
        s.setSubscriptionType(subscriptionTypeService.getById(subscriptionTypeId));
        s.setClient(clientService.getById(clientId));
        s.setSubscriptionID(subscriptionID);

        this.subscriptionService.add(s);
        return "redirect:/subscription/list/" + clientId ;
    }

    @PostMapping({"/update/{id}"})
    public String update (Model model, @PathVariable int id) {
        List<Subscription> list = subscriptionService.getAll();
        Subscription s = subscriptionService.getById(id);
        Client c = s.getClient();
        model.addAttribute("subscriptionList", c.getSubscriptionList() );
        model.addAttribute("subscription", s);
        model.addAttribute("subscriptionTypeList", subscriptionTypeService.getAll());
        return "subscriptionList";
    }

    private Date convertStringToDate(String startDate) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
