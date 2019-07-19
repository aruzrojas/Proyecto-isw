package hello.controller;

import hello.entity.Usuario;
import hello.service.UserService;
import hello.service.SecurityService;
import hello.validator.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UsuarioValidator userValidator;

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("userForm", new Usuario());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult){
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()){
            return "signup";
        }

        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/secret";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        if(error != null){
            model.addAttribute("error","Contraseña o Password inválida");
        }
        if(logout != null){
            model.addAttribute("message","Te desloggeaste");
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model){


        
        return "secret";
    }
}
