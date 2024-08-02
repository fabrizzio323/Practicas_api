package fabrizio.armada.practica.service;

import java.time.LocalDate;

import java.util.List;

import fabrizio.armada.practica.model.Cliente;
import fabrizio.armada.practica.model.Producto;
import fabrizio.armada.practica.model.ResumenVenta;
import fabrizio.armada.practica.model.Venta;

public interface VentaService {
     public List<Venta> getAllVentas();
     public void createVenta(Venta venta);
     public void deleteVenta(Long codigo_venta);
     public Venta getVenta(Long codigo_venta);
     public Venta editVenta(Long codigo_venta, Venta ventaEditada);
     public List<Producto> getAllProductosOfVentas(Long codigo_venta);
     public ResumenVenta montoTotalPorFecha(LocalDate fecha);
}
