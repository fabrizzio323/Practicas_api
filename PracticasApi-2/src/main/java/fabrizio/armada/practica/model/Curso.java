package fabrizio.armada.practica.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="CURSO")
public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_curso")
	private Long id_curso;
    @Column(name="nombre_curso")
	private String nombre;
    @Column(name="modalidad_curso")
	private String modalidad;
    @Column(name="FechaInicio_curso")
	private LocalDate fecha_inicializacion;
    @OneToMany
	private List<Tema> listaTemas;
}
