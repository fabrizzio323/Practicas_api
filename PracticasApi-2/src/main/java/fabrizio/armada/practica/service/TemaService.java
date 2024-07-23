package fabrizio.armada.practica.service;

import java.util.List;

import fabrizio.armada.practica.model.Tema;

public interface TemaService {
    public List<Tema> getAllTema();
	public void saveTema(Tema tema);
    public void deleteTema(Long id);
    public void editTema(Tema tema);
    
}
