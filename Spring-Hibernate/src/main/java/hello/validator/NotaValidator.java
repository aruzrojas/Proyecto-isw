package hello.validator;

import hello.entity.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hello.service.NotaService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;


@Component
public class NotaValidator implements Validator {
    @Autowired
    private NotaService notaService;

    @Override
    public boolean supports(Class<?> aClass){
        return Nota.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors){
        Nota nota = (Nota) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","NotEmpty");
        if(nota.getNombre().length() <3 || nota.getNombre().length()>20){
            errors.rejectValue("nombre","Size.notaForm.nombre");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"contenido","NotEmpty");
        if(nota.getContenido().length()<10 || nota.getContenido().length()>99){
            errors.rejectValue("contenido","Size.notaForm.contenido");
        }

    }
}
