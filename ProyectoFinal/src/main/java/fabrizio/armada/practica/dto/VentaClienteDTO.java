package fabrizio.armada.practica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaClienteDTO {
     private Long codigo_venta;
     private Double total;
     private int cantidadProductos;
     private String nombreCliente;
     private String apellidoCliente;
     
}
