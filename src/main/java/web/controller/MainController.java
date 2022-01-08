package web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Role;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;

import java.util.Collections;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    public MainController() {
    }


    private UserService userService;

    @GetMapping(value = "/admin")
    public String printUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "main";
    }

    @GetMapping(value = "admin/delete")
    public String delete(long id, Model model) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping(value = "admin/edit")
    public String edit(Model model, long id) {
        model.addAttribute("user", userService.get(id));
        return "edit";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping("admin/edit")
    public String edit(Model model, User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @PostMapping(value = "/add")
    public String add(Model model, User user) {
        user.setRoles(Collections.singleton(new Role("ROLE_ADMIN")));
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String user(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "infoAboutUser";
    }
}

