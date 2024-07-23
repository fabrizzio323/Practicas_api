package fabrizio.armada.practica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="DUEÑO")
public class Dueño {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="D_id")
    private Long idDueño;
	@Column(name="D_dni")
    private String dni;
	@Column(name="D_nombre")
    private String nombre;
	@Column(name="D_apellido")
    private String apellido;
	@Column(name="D_celular")
    private String celular;
}
