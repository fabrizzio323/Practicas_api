package fabrizio.armada.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabrizio.armada.practica.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
