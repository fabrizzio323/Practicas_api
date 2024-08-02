package fabrizio.armada.practica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="PRODUCTO")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="P_codigo")
   private Long codigo_producto;
	@Column(name="P_nombre")
   private String nombre;
	@Column(name="P_marca")
   private String marca;
	@Column(name="P_costo")
   private Double costo;
	@Column(name="P_cantidadDisponible")
   private Integer cantidad_disponible;
	
}
