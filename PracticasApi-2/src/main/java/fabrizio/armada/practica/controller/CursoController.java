package fabrizio.armada.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fabrizio.armada.practica.dto.CursoTemaDTO;
import fabrizio.armada.practica.model.Curso;
import fabrizio.armada.practica.serviceImp.CursoServiceImp;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CursoController {
       @Autowired
       CursoServiceImp ICurso;
       
       @GetMapping("/curso/crear")
       public String createCurso(@RequestBody Curso curso) {
    	   ICurso.saveCurso(curso);
    	   return "Curso creado con exito";
       }
       
       @GetMapping("/curso/listar")
       public List<Curso> getAllCursos(){
    	   return ICurso.getAllCursos();
       }
       
       @GetMapping("/curso/temas/{id}")
       public CursoTemaDTO getAllTemasOfCurso(@PathVariable Long id) {
    	   return ICurso.getAllTemasOfCurso(id);
       }
       
       @GetMapping("/cursos/java")
       public List<Curso> getAllCursosOfJava() {
           return ICurso.getAllCursosJava();
       }
       
       @PutMapping("/curso/editar")
       public String editCurso(@RequestBody Curso curso) {
    	   ICurso.editCurso(curso);
    	   return"Curso edita con exito";
       }
       
       @DeleteMapping("/curso/eliminar/{id}")
       public String deleteCurso(@PathVariable Long id) {
    	   ICurso.deleteCurso(id);
    	   return "Curso eliminado con exito";
       }
}
