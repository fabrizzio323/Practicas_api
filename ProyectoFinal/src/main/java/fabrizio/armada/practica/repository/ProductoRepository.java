package fabrizio.armada.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabrizio.armada.practica.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
