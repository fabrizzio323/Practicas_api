package fabrizio.armada.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabrizio.armada.practica.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long>{

}
