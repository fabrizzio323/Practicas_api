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

import fabrizio.armada.practica.model.Tema;
import fabrizio.armada.practica.serviceImp.TemaServiceImp;

@RestController
public class TemaController {
        
	 @Autowired
	 private TemaServiceImp ITema;
	 
	 
	 @PostMapping("/tema/crear")
	 public String createTema(@RequestBody Tema tema) {
		 ITema.saveTema(tema);
	 	return "Tema creado con exito";
	 }
	 
	 @GetMapping("/tema/listar")
	 public List<Tema> getAllTemas(){
		 return ITema.getAllTema();
	 }
	 
	 @DeleteMapping("/tema/eliminar/{id}")
	 public String delteTema(@PathVariable Long id) {
		 ITema.deleteTema(id);
		 return "Tema eliminado con exito";
	 }
	 @PutMapping("/tema/editar")
	 public String editTema(@RequestBody Tema tema) {
		 ITema.editTema(tema);
		 return "Tema editado con exito";
	 }
	
	 
}
