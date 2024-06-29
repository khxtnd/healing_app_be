package khTeam.healing_be.controller;

import khTeam.healing_be.entity.ContactEntity;
import khTeam.healing_be.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/")
    public String homepage() {
        List<ContactEntity> contactEntities = contactService.findAll();
        return "index";
    }

    @GetMapping("/aloalo")
    public String alo() {
        return "alo";
    }
}

