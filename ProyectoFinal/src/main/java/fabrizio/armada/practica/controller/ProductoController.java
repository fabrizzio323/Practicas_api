package fabrizio.armada.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fabrizio.armada.practica.model.Producto;
import fabrizio.armada.practica.serviceImp.ProductoServiceImp;

@RestController
public class ProductoController {
  
	 @Autowired
	 private ProductoServiceImp IProducto;
     
	 @PostMapping("/productos/crear")
	 public String createProducto(@RequestBody Producto producto) {
		 IProducto.createProducto(producto);
		 return "Producto creado con exito";
	 }
	 
	 @GetMapping("/productos")
	 public List<Producto> getAllProducto(){
		 return IProducto.getAllProductos();
	 }
	 
     @GetMapping("/productos/{codigo_producto}")
     public Producto getProducto(@PathVariable Long codigo_producto) {
    	 return IProducto.getProductoBydId(codigo_producto);
     }
     
     @GetMapping("/productos/sin_stock")
     public List<Producto> getAllSinStock(){
    	 return IProducto.getAllSinStock();
     }
     
     @DeleteMapping("/productos/eliminar/{codigo_producto}")
     public String deleteProducto(@PathVariable Long codigo_producto) {
    	 IProducto.deleteProducto(codigo_producto);
    	 return"Producto eliminado con exito";
     }
     
     @PutMapping("/productos/editar/{codigo_producto}")
     public Producto editProducto(@PathVariable Long codigo_producto,
    		                    @RequestBody Producto nuevoProducto) {
    	 
         IProducto.editProducto(codigo_producto, nuevoProducto);
         Producto producto = IProducto.getProductoBydId(codigo_producto);
         return producto;
     }
}
