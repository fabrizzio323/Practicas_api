package fabrizio.armada.practica.service;

import java.util.List;

import fabrizio.armada.practica.dto.MascotaDueñoDTO;
import fabrizio.armada.practica.model.Mascota;

public interface MascotaService {
   public List<Mascota> getAllMascotas();
   public void saveMascota(Mascota mascota);
   public void deleteMascota(Long id);
   public Mascota findMascota(Long id);
   public void editMascota(Mascota mascota);
   public List<Mascota> getMascotaCaniche();
   public List<MascotaDueñoDTO> getMascotaDueñoDTO();
}
