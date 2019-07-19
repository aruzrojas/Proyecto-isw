package hello.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import hello.converter.Convertidor;
import hello.entity.Nota;
import hello.model.MNota;
import hello.repository.NotaRepositorio;

import java.util.List;



@Service("servicio")
public class NotaService {
	@Autowired
	@Qualifier("repositorio")
	private NotaRepositorio repositorio;

	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	public boolean crear(Nota nota){
		try{
			repositorio.save(nota);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean actualizar(Nota nota){
		try{
			repositorio.save(nota);

			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean borrar(String nombre, long id){
		try{
			Nota nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);

			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List<MNota> obtener(){
		return convertidor.convertirLista(repositorio.findAll());
	}

	public MNota obtenerPorNombreTitulo(String nombre, String titulo){
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}

	public List<MNota> obtenerTitulo(String titulo){
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}

	public List<MNota> obtenerPorPaginacion(Pageable pageable){
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
	}
}