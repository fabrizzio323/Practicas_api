package fabrizio.armada.practica.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fabrizio.armada.practica.model.Producto;
import fabrizio.armada.practica.repository.ProductoRepository;
import fabrizio.armada.practica.service.ProductoService;



@Service
public class ProductoServiceImp implements ProductoService{
 
	 @Autowired
	 private ProductoRepository productoRepository;

	@Override
	public List<Producto> getAllProductos() {
		List<Producto> productos = productoRepository.findAll();
		return productos;
	}

	@Override
	public Producto getProductoBydId(Long codigo) {
		Optional<Producto> productoOp = productoRepository.findById(codigo);
		Producto producto = new Producto();
		if(productoOp!=null) {
			producto = productoOp.get();
		}
		return producto;
	}

	@Override
	public void createProducto(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void deleteProducto(Long codigo) {
		productoRepository.deleteById(codigo);
	}

	@Override
	public Producto editProducto(Long codigo, Producto nuevoProducto) {
		Optional<Producto> productoOp = productoRepository.findById(codigo);
		Producto producto = new Producto();
		if(productoOp.isPresent()) {
			producto = productoOp.get();
			if(nuevoProducto.getNombre()!= null) producto.setNombre(nuevoProducto.getNombre());
			if(nuevoProducto.getMarca() != null)  producto.setMarca(nuevoProducto.getMarca());
			if(nuevoProducto.getCosto()!= null)  producto.setCosto(nuevoProducto.getCosto());
			if(nuevoProducto.getCantidad_disponible()!= null) producto.setCantidad_disponible(nuevoProducto.getCantidad_disponible());
			productoRepository.save(producto);
			return producto;
		}else {
			throw new NoSuchElementException("No se encotro el producto con el codigo: " + codigo);
		}
		
		
	}

	@Override
	public List<Producto> getAllSinStock() {
		List<Producto> productos = productoRepository.findAll();
		List<Producto> sinStock = new ArrayList<Producto>();
		for(Producto i : productos) {
			if(i.getCantidad_disponible()<5) {
				sinStock.add(i);
			}
		}
		return sinStock;
	}

}
