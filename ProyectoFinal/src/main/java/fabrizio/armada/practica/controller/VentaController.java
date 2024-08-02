package fabrizio.armada.practica.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fabrizio.armada.practica.dto.VentaClienteDTO;
import fabrizio.armada.practica.model.Cliente;
import fabrizio.armada.practica.model.Producto;
import fabrizio.armada.practica.model.ResumenVenta;
import fabrizio.armada.practica.model.Venta;
import fabrizio.armada.practica.serviceImp.VentaServiceImp;

@RestController
public class VentaController {
    
	  @Autowired
	  private VentaServiceImp IVenta;
	  @PostMapping("/ventas/crear")
	  public String createVenta(@RequestBody Venta venta) {
		  IVenta.createVenta(venta);
		  return "Venta creada con exito";
	  }
	  
	  @GetMapping("/ventas")
	  public List<Venta> getAllVentas(){
		  return IVenta.getAllVentas();
	  }
	  
	  @GetMapping("/ventas/{codigo_venta}")
	  public Venta getVenta(@PathVariable Long codigo_venta) {
		  return IVenta.getVenta(codigo_venta);
	  }
	  
	  @GetMapping("/ventas/productos/{codigo_venta}")
	  public List<Producto> getAllProductosOfVentas(@PathVariable Long codigo_venta){
		  return IVenta.getAllProductosOfVentas(codigo_venta);
	  }
	  
	  @GetMapping("/venta/{fecha_venta}")
	  public ResumenVenta getResumen(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha_venta) {
		  return IVenta.montoTotalPorFecha(fecha_venta);
	  }
	  
	  @GetMapping("/ventas/mayor_venta")
	  public VentaClienteDTO getVentaMayor() {
		  return IVenta.ventaMasCara();
	  }
	  
	  @DeleteMapping("/ventas/eliminar/{codigo_venta}")
	  public String deleteVenta(@PathVariable Long codigo_venta) {
		  IVenta.deleteVenta(codigo_venta);
		  return "Venta eliminada con exito";
	  }
	  
	  @PutMapping("/ventas/editar/{codigo_venta}")
	  public Venta editVenta(@PathVariable Long codigo_venta,
			                 @RequestBody Venta ventaEditada) {
		  IVenta.editVenta(codigo_venta, ventaEditada);
		  Venta venta = IVenta.getVenta(codigo_venta);
		  return venta;
	  }
	                     
	  
}
