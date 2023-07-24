package com.example.dz24.UserController;

import com.example.dz24.domen.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private List<User> users = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        users.add(user);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        users.removeIf(user -> user.getId().equals(id));
        return "redirect:/";
    }
}
