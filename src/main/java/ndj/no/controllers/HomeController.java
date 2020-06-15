package ndj.no.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private static final Logger logger = Logger.getLogger(HomeController.class);

    @GetMapping("/")
    public String home(Model model) {

        return "home";
    }
}
