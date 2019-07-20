package hello.controller;

import hello.entity.Nota;
import hello.service.NotaService;
import hello.validator.NotaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotaController {
    @Autowired
    private NotaService notaService;

    @Autowired
    private NotaValidator notaValidator;


    @GetMapping("/secret")
    public String secret(Model model){
        model.addAttribute("notaForm", new Nota());
        return "secret";
    }

    @PostMapping("/secret")
    public String secret(@ModelAttribute("userForm") Nota notaForm, BindingResult bindingResult){
        notaValidator.validate(notaForm, bindingResult);

        if (notaService.crear(notaForm)){
        	return "redirect:/secret";
        }
        else{
        	return "greeting";
        }
                
        
    }

}
