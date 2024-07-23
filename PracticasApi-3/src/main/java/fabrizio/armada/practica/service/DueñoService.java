package fabrizio.armada.practica.service;

import java.util.List;

import fabrizio.armada.practica.model.Dueño;

public interface DueñoService {
	   public List<Dueño> getAllDueños();
	   public void saveDueño(Dueño dueño);
	   public void deleteDueño(Long id);
	   public Dueño findDueño(Long id);
	   public void editDueño(Dueño dueño);
}
