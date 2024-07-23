package fabrizio.armada.practica.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fabrizio.armada.practica.model.Dueño;
import fabrizio.armada.practica.repository.DueñoRepository;
import fabrizio.armada.practica.service.DueñoService;

@Service
public class DueñoServiceImp implements DueñoService{

	@Autowired
	private DueñoRepository dueñoRepository;

	@Override
	public List<Dueño> getAllDueños() {
		List<Dueño> dueños = dueñoRepository.findAll();
		return dueños;
	}

	@Override
	public void saveDueño(Dueño dueño) {
		dueñoRepository.save(dueño);
		
	}

	@Override
	public void deleteDueño(Long id) {
		dueñoRepository.deleteById(id);
		
	}

	@Override
	public Dueño findDueño(Long id) {
		Optional<Dueño> dueñoOp = dueñoRepository.findById(id);
		Dueño dueño = new Dueño();
		if(dueñoOp != null) {
			dueño = dueñoOp.get();
		}
		return dueño;
	}

	@Override
	public void editDueño(Dueño dueño) {
		dueñoRepository.save(dueño);
		
	}
	
	

}
