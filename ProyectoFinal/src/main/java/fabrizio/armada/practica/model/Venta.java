package fabrizio.armada.practica.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="VENTA")
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="V_codigo")
	private Long codigo_venta;
	@Column(name="V_fechaVenta")
    private LocalDate fechaVenta;
	@Column(name="V_total")
	private double total;
	@OneToMany
	private List<Producto> listaProductos;
	@OneToOne
	@JoinColumn(name="idCliente", referencedColumnName = "C_id")
	private Cliente unCliente;
}
