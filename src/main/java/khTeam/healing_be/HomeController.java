package khTeam.healing_be;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homepage() {
        return "index";
    }

    @GetMapping("/aloalo")
    public String alo() {
        return "alo";
    }
}

