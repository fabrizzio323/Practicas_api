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
@Entity(name="MASCOTA")
public class Mascota {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="M_id")
   private Long idMascota;
   @Column(name="M_nombre")
   private String nombre;
   @Column(name="M_especie")
   private String especie;
   @Column(name="M_raza")
   private String raza;
   @Column(name="M_color")
   private String color;
   @OneToOne
   @JoinColumn(name="id_dueño", referencedColumnName="D_id")
   private Dueño unDueño;
}
