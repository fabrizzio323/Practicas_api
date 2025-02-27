package fabrizio.armada.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabrizio.armada.practica.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{

}
