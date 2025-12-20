package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import web.DAO.UserDAO;
import web.model.User;

@Controller
@RequestMapping("/usersList")
public class UserController {

    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @GetMapping()
    public String printUser(Model model) {
        model.addAttribute("users", userDAO.findAll() );
        model.addAttribute("user", new User());
        return "usersList";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userDAO.saveUser(user);
        return "redirect:/usersList";
    }

    @GetMapping("/delete")
    public String deleteUser(@ModelAttribute("id") int id) {
        userDAO.deleteUser(id);
        return "redirect:/usersList";
    }

    @GetMapping("/update")
    public String updateUser(@ModelAttribute("id") int id, Model model) {
        model.addAttribute("users", userDAO.findAll() );
        model.addAttribute("user", userDAO.getUserById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userDAO.updateUser(user);
        return "redirect:/usersList";
    }
}