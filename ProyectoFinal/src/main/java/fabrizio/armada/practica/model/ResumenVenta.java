package fabrizio.armada.practica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumenVenta {
   private double monto;
   private int totalVentas;
}
