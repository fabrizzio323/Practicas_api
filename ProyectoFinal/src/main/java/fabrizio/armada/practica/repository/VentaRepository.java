package fabrizio.armada.practica.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabrizio.armada.practica.dto.VentaClienteDTO;
import fabrizio.armada.practica.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFechaVenta(LocalDate fechaVenta);
}
