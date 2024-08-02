package fabrizio.armada.practica.service;

import java.util.List;

import fabrizio.armada.practica.model.Producto;

public interface ProductoService {
       public List<Producto> getAllProductos();
       public Producto getProductoBydId(Long codigo);
       public void createProducto(Producto producto);
       public void deleteProducto(Long codigo);
       public Producto editProducto(Long codigo, Producto nuevoProducto);
       public List<Producto> getAllSinStock();
}
