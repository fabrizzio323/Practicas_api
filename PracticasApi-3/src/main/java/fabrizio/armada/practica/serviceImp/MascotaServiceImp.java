package fabrizio.armada.practica.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fabrizio.armada.practica.dto.MascotaDueñoDTO;
import fabrizio.armada.practica.model.Mascota;
import fabrizio.armada.practica.repository.MascotaRepository;
import fabrizio.armada.practica.service.MascotaService;

@Service
public class MascotaServiceImp implements MascotaService{

	@Autowired
	private MascotaRepository mascotaRepository;
	
	@Override
	public List<Mascota> getAllMascotas() {
		List<Mascota> mascotas = mascotaRepository.findAll();
		return mascotas;
	}

	@Override
	public void saveMascota(Mascota mascota) {
		mascotaRepository.save(mascota);
	}

	@Override
	public void deleteMascota(Long id) {
		mascotaRepository.deleteById(id);
	}

	@Override
	public Mascota findMascota(Long id) {
		Optional<Mascota> mascotaOp = mascotaRepository.findById(id);
		Mascota mascota = new Mascota();
		if(mascotaOp != null) {
		 mascota = mascotaOp.get();
		}
		return mascota;
	}

	@Override
	public void editMascota(Mascota mascota) {
		mascotaRepository.save(mascota);		
	}

	@Override
	public List<Mascota> getMascotaCaniche() {
		List<Mascota> mascotas = mascotaRepository.findAll();
		List<Mascota> mascotasCaniche = new ArrayList<Mascota>();
		for(Mascota i : mascotas) {
			if(i.getEspecie().equalsIgnoreCase("perro") && i.getRaza().equalsIgnoreCase("caniche")) {
				mascotasCaniche.add(i);
			}
		}
		return mascotasCaniche;
	}

	@Override
	public List<MascotaDueñoDTO> getMascotaDueñoDTO() {
		List<Mascota> mascotas = mascotaRepository.findAll();
		List<MascotaDueñoDTO> mascotasDTO = new ArrayList<MascotaDueñoDTO>();
		MascotaDueñoDTO mascotaDTO = new MascotaDueñoDTO();
		for(Mascota i : mascotas) {
			mascotaDTO.setNombreDueño(i.getUnDueño().getNombre());
			mascotaDTO.setApellidoDueño(i.getUnDueño().getApellido());
			mascotaDTO.setNombreMascota(i.getNombre());
			mascotaDTO.setEspecie(i.getEspecie());
			mascotaDTO.setRaza(i.getRaza());
			mascotasDTO.add(mascotaDTO);
		}
		return mascotasDTO;
	}

}
