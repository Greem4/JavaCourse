package com.greem4.spring.http.controller;

import com.greem4.spring.dto.UserCreateEditDto;
import com.greem4.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAll(Model model) {
//        model.addAttribute("users", userService.findAll);
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
//        model.addAttribute("user", userService.findById(id));
        return "user/user";
    }

    @PostMapping
    public String create(UserCreateEditDto user) {
//        userService.create(user);
        return "redirect:/users/" + 25;
    }

    //    @PutMapping("/{id}")
    @PutMapping("/{id}/update")
    public String updste(@PathVariable("id") Long id, UserCreateEditDto user) {
//        userService.update(id, user);
        return "redirect:/users/{id}";
    }

    //    @DeleteMapping("/{id}")
    @PutMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
//        userService.delete(id);
        return "redirect:/users";
    }
}
