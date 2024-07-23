package fabrizio.armada.practica.serviceImp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fabrizio.armada.practica.dto.CursoTemaDTO;
import fabrizio.armada.practica.model.Curso;
import fabrizio.armada.practica.model.Tema;
import fabrizio.armada.practica.repository.CursoRepository;
import fabrizio.armada.practica.service.CursoService;

@Service
public class CursoServiceImp implements CursoService{

	 @Autowired
	 CursoRepository cursoRepository;

	@Override
	public void saveCurso(Curso curso) {
		cursoRepository.save(curso);
		
	}

	@Override
	public void deleteCurso(Long id) {
		cursoRepository.deleteById(id);
		
	}

	@Override
	public List<Curso> getAllCursos() {
		List<Curso> cursos = cursoRepository.findAll();
		return cursos;
	}

	@Override
	public List<Curso> getAllCursosJava() {
		String palabra="Java";
		String textoComparar;
		boolean band;
		List<Curso> cursosJava = new ArrayList<Curso>();
		List<Curso> cursos = cursoRepository.findAll();
		for(Curso i: cursos) {
			textoComparar = i.getNombre();
			band = textoComparar.contains(palabra);
			if(band==true) {
				cursosJava.add(i);
			}
		}
		return cursosJava;
	}

	@Override
	public CursoTemaDTO getAllTemasOfCurso(Long id) {
		CursoTemaDTO cursoDTO = new CursoTemaDTO();
		Optional<Curso> cursoOp = cursoRepository.findById(id);
		if(cursoOp!=null) {
			Curso curso = cursoOp.get();
			cursoDTO.setNombre(curso.getNombre());
			cursoDTO.setListaTemas(curso.getListaTemas());
		}
		return cursoDTO;
	}

	@Override
	public void editCurso(Curso curso) {
		cursoRepository.save(curso);
		
	}
	 
	

}
