package fabrizio.armada.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabrizio.armada.practica.model.Dueño;

@Repository
public interface DueñoRepository extends JpaRepository<Dueño, Long>{

}
