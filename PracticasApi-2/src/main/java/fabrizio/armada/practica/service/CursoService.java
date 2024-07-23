package fabrizio.armada.practica.service;

import java.util.List;

import fabrizio.armada.practica.dto.CursoTemaDTO;
import fabrizio.armada.practica.model.Curso;

public interface CursoService {
    public void saveCurso(Curso curso);
    public void deleteCurso(Long id);
    public List<Curso> getAllCursos();
    public List<Curso> getAllCursosJava();
    public CursoTemaDTO getAllTemasOfCurso(Long id);
    public void editCurso(Curso curso);
}
