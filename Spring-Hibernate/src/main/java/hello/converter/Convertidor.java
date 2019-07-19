package hello.converter;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import hello.entity.Nota;
import hello.model.*;

@Component("convertidor")
public class Convertidor {
	public List<MNota> convertirLista(List<Nota> notas){
		List<MNota> mnotas = new ArrayList<>();

		for(Nota nota : notas){
			mnotas.add(new MNota(nota));
		}
		return mnotas;
	}
	
}