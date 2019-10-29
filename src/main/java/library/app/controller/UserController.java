package library.app.controller;

import javax.validation.Valid;

import library.app.dto.UserRegistrationDto;
import library.app.entity.User;
import library.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserRegistrationDto userDto = new UserRegistrationDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String registerUserAccount(
            @ModelAttribute("user") @Valid UserRegistrationDto accountDto, BindingResult result) {

        User registered = new User();
        registered = createUserAccount(accountDto, result);
        return "login";
    }

    private User createUserAccount(UserRegistrationDto accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (Exception e) {
            return null;
        }
        return registered;
    }
}
