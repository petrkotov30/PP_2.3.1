package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.showAllUser());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("user", userService.findUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute User user, @PathVariable("id") long id) {
        userService.update(user, id);
        System.out.println(user.getName());
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}