package fabrizio.armada.practica.controller;

import org.springframework.web.bind.annotation.RestController;

import fabrizio.armada.practica.model.Cliente;
import fabrizio.armada.practica.serviceImp.ClienteServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ClienteController {
         
	   @Autowired
	   private ClienteServiceImp ICliente;
	
	   @PostMapping("/clientes/crear")
	   public String createCliente(@RequestBody Cliente cliente) {
		   ICliente.createCliente(cliente);
		   return "Cliente creado con exito";
	   }
	   
	   @GetMapping("/clientes")
       public List<Cliente> getAllClientes(){
		   return ICliente.getAllClientes();
	   }
	   
	   @GetMapping("/clientes/{id_cliente}")
	   public Cliente getCliente(@PathVariable Long id_cliente) {
		   Cliente encontrado = ICliente.getCliente(id_cliente);
		   return encontrado;
	   }
	   
	   @DeleteMapping("/clientes/eliminar/{id_cliente}")
	   public String deleteCliente(@PathVariable Long id_cliente) {
		   ICliente.deleteCliente(id_cliente);
		   return "Cliente eliminado con exito";
	   }
	   
	   @PutMapping("/clientes/editar/{id_cliente}")
	   public Cliente editCliete(@PathVariable Long id_cliente, 
			                    @RequestBody Cliente nuevoCliente) {
             ICliente.editCliente(id_cliente, nuevoCliente);
             Cliente cliente = ICliente.getCliente(id_cliente);
             return cliente;
	   }
}
