package fabrizio.armada.practica.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fabrizio.armada.practica.model.Tema;
import fabrizio.armada.practica.repository.TemaRepository;
import fabrizio.armada.practica.service.TemaService;

@Service
public class TemaServiceImp implements TemaService{
     
	@Autowired
	TemaRepository temaRepository;

	@Override
	public List<Tema> getAllTema() {
		List<Tema> temas = temaRepository.findAll();
		return temas;
	}

	@Override
	public void saveTema(Tema tema) {
		temaRepository.save(tema);
		
	}

	@Override
	public void deleteTema(Long id) {
		temaRepository.deleteById(id);
		
	}


	@Override
	public void editTema(Tema tema) {
		temaRepository.save(tema);
		
	}
	
	
}
