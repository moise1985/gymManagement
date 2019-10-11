package com.sda.gym.Controller;

import com.sda.gym.Entity.Client;
import com.sda.gym.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public String clientList(Model model){
        List<Client> list = clientService.getAll();
        model.addAttribute("clientList", list );
        model.addAttribute("client", new Client());
        return "clientList";
    }

    @PostMapping({"/delete/{id}"})
    public String delete (@PathVariable int id) {
        this.clientService.delete(id);
        return "redirect:/client/list";
    }

    @PostMapping({"/save"})
    public String save (@ModelAttribute Client client){
        this.clientService.add(client);
        return "redirect:/client/list";
    }

    @PostMapping({"/update/{id}"})
    public String update (Model model, @PathVariable int id) {
        List<Client> list = clientService.getAll();
        model.addAttribute("clientList", list );
        model.addAttribute("client", this.clientService.getById(id));
        return "clientList";
    }








}
