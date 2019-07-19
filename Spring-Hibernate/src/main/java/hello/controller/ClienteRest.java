package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import hello.entity.Nota;

@Controller
@RequestMapping("/nota")
public class ClienteRest {
	
	@GetMapping("/all")
	public ModelAndView devolverTodos(){

		ModelAndView mav = new ModelAndView("template");

		RestTemplate rest = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		HttpEntity entity = new HttpEntity(headers);

		ResponseEntity<Nota[]> notasEntity = rest.exchange("http://localhost:8000/v1/notas", HttpMethod.GET, entity, Nota[].class);

		Nota[] notas = notasEntity.getBody();

		mav.addObject("notas", notas);

		return mav;
	}
}