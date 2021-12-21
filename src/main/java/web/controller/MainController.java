package web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.IUserService;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/go")
    public String printUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "main";
    }

    @GetMapping(value = "/delete")
    public String delete(long id, Model model) {
        userService.delete(id);
        return "redirect:/go";
    }

    @GetMapping(value = "/edit")
    public String edit(Model model, long id) {
        model.addAttribute("user", userService.get(id));
        return "edit";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping("/edit")
    public String edit(Model model, User user) {
        userService.update(user);
        return "redirect:/go";
    }

    @PostMapping(value = "/add")
    public String add(Model model, User user) {
        userService.add(user);
        return "redirect:/go";
    }
}

