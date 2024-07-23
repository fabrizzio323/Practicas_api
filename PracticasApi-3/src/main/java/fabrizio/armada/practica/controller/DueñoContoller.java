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

import fabrizio.armada.practica.model.Dueño;
import fabrizio.armada.practica.serviceImp.DueñoServiceImp;

@RestController
public class DueñoContoller {
 
	 @Autowired
	 private DueñoServiceImp IDueño;
	 @PostMapping("/dueño/crear")
	 public String createDueño(@RequestBody Dueño dueño) {
		 IDueño.saveDueño(dueño);
		 return "Dueño creado con exito";
	 }
	 
	 @GetMapping("/dueño/listar")
	 public List<Dueño> getAllDueños(){
		 return IDueño.getAllDueños();
	 }
	 
	 @DeleteMapping("/dueño/eliminar/{id}")
	 public String deleteDueño(@PathVariable Long id) {
		 IDueño.deleteDueño(id);
		 return "Dueño eliminado con exito";
	 }
	 
	 @PutMapping("/dueño/editar")
	 public String editDueño(@RequestBody Dueño dueño) {
		 IDueño.editDueño(dueño);
		 return "Dueño editado con exito";
	 }
}
