package fabrizio.armada.practica.serviceImp;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fabrizio.armada.practica.dto.VentaClienteDTO;
import fabrizio.armada.practica.model.Cliente;
import fabrizio.armada.practica.model.Producto;
import fabrizio.armada.practica.model.ResumenVenta;
import fabrizio.armada.practica.model.Venta;
import fabrizio.armada.practica.repository.VentaRepository;
import fabrizio.armada.practica.service.VentaService;

@Service
public class VentaServiceImp implements VentaService{

	@Autowired
	private VentaRepository ventaRepository;
	

	
	@Override
	public List<Venta> getAllVentas() {
		List<Venta> ventas = ventaRepository.findAll(); 
		return ventas;
	}

	@Override
	public void createVenta(Venta venta) {
		ventaRepository.save(venta);
		
	}

	@Override
	public void deleteVenta(Long codigo_venta) {
		ventaRepository.deleteById(codigo_venta);
		
	}

	@Override
	public Venta getVenta(Long codigo_venta) {
		Optional<Venta> ventaOp = ventaRepository.findById(codigo_venta);
		Venta venta = new Venta();
		if(ventaOp != null) {
			venta = ventaOp.get();
		}
		return venta;
	}

	@Override
	public Venta editVenta(Long codigo_venta, Venta ventaEditada) {
		Optional<Venta> ventaOp = ventaRepository.findById(codigo_venta);
		Venta venta = new Venta();
		if(ventaOp.isPresent()) {
			venta = ventaOp.get();
			if(ventaEditada.getFechaVenta() != null) venta.setFechaVenta(ventaEditada.getFechaVenta());
		    if(ventaEditada.getTotal()!= 0.0) venta.setTotal(ventaEditada.getTotal());
		    if(ventaEditada.getListaProductos() != null) venta.setListaProductos(ventaEditada.getListaProductos());
		    if(ventaEditada.getUnCliente()!= null) venta.setUnCliente(ventaEditada.getUnCliente());
		    ventaRepository.save(venta);
		    return venta;
		}else {
			throw new NoSuchElementException("No se encuentra la venta con el codigo: " + codigo_venta);
		}
	}

	@Override
	public List<Producto> getAllProductosOfVentas(Long codigo_venta) {
		Optional<Venta> ventaOp = ventaRepository.findById(codigo_venta);
		if(ventaOp.isPresent()) {
			Venta venta = ventaOp.get();
			List<Producto> productos = venta.getListaProductos();
			return productos;
		}else {
			throw new NoSuchElementException("No se encontro la venta con el codigo: " + codigo_venta);
		}
	}

	@Override
	public ResumenVenta montoTotalPorFecha(LocalDate fecha_venta) {
		List<Venta> ventas = ventaRepository.findByFechaVenta(fecha_venta);
        double montoTotal = 0.0;
        int totalVentas = 0;
        for(Venta i : ventas) {
        	montoTotal = montoTotal + i.getTotal();
        }
        for(Venta j : ventas) {
        	totalVentas++;
        }
		return new ResumenVenta(montoTotal, totalVentas);
	}

    public VentaClienteDTO ventaMasCara() {
    	List<Venta> ventas = ventaRepository.findAll();
    	Venta ventaMayor = ventas.get(0);
        double max = ventas.get(0).getTotal();
    	for(Venta i : ventas) {
    		if(i.getTotal() > max) {
    			max = i.getTotal();
    			ventaMayor=i;
    		}
    	}
    	return new VentaClienteDTO(ventaMayor.getCodigo_venta(), ventaMayor.getTotal(), ventaMayor.getListaProductos().size(), 
    			                   ventaMayor.getUnCliente().getNombre(), ventaMayor.getUnCliente().getApellido());
    }
	

}
