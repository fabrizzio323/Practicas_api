package fabrizio.armada.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fabrizio.armada.practica.dto.MascotaDueñoDTO;
import fabrizio.armada.practica.model.Mascota;
import fabrizio.armada.practica.serviceImp.MascotaServiceImp;

@RestController
public class MascotaController {
   
	@Autowired
	private MascotaServiceImp IMascota;
	
	@GetMapping("/mascota/listar")
	public List<Mascota> getMethodName() {
		return IMascota.getAllMascotas();
	}
	@GetMapping("/mascota/perro/caniche/listar")
	public List<Mascota> getAllPerrosCaniches(){
		return IMascota.getMascotaCaniche();
	}
	@GetMapping("/mascota/dueño")
	public List<MascotaDueñoDTO> getDueñoMascota() {
		return IMascota.getMascotaDueñoDTO();
	}
	
	@PostMapping("/mascota/crear")
	public String createMascota(@RequestBody Mascota mascota) {
		IMascota.saveMascota(mascota);
		return "Mascota creada con exito";
	}
	
	@DeleteMapping("/mascota/eliminar/{id}")
	public String deleteMascota(@PathVariable Long id) {
		IMascota.deleteMascota(id);
		return "Mascota eliminada con exito";
	}
	
	@PutMapping("/mascota/editar")
	public String editMascota(@RequestBody Mascota mascota) {
	   IMascota.editMascota(mascota);
	   return "Mascota editada con exito";
	}
}
