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
@Entity(name="CLIENTE")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="C_id")
	private Long id_cliente;
	@Column(name="C_nombre")
	private String nombre;
	@Column(name="C_apellido")
	private String apellido;
	@Column(name="C_dni")
	private String dni;
}
