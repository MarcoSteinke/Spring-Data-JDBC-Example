package de.hhu.propra.webserver;

import de.hhu.propra.webserver.model.User;
import de.hhu.propra.webserver.services.Fehler;
import de.hhu.propra.webserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    UserService userService;

    @Autowired
    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @PostMapping("/register")
    public String register(Model model, @RequestParam String username, @RequestParam String password) {

        if(userService.registerUser(username, password)) {
            User user = this.userService.loadUser(username);
            if(user.isValid()) {
                model.addAttribute("username", user.getUsername());
                return "success";
            }
        } else {
            model.addAttribute("error", Fehler.USER_EXISTS);
            return "error";
        }

        return "index";
    }
}
