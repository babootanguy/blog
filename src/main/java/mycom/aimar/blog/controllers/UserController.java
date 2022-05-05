package mycom.aimar.blog.controllers;

import lombok.RequiredArgsConstructor;
import mycom.aimar.blog.entities.User;
import mycom.aimar.blog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller @RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path="/users")
    public String getUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(path = "/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping(path = "/register")
    public String addUser(@RequestParam String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userService.addUser(user);

        return "redirect:/users";
    }

}
