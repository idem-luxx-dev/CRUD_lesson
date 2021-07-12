package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getAll(ModelMap model){
        model.addAttribute("users", service.getAllUsers());
        User user1 = new User();
        user1.setId(10000L);
        model.addAttribute("user1", user1);
        return "all";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user1") User user1) {
        service.createOrUpdateUser(user1);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        service.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@ModelAttribute("id") int id, ModelMap model){
        model.addAttribute("user", service.getUser(id));
        return "edit";
    }

}

