package fabrizio.armada.practica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDueñoDTO {
   private String nombreMascota;
   private String especie;
   private String raza;
   private String nombreDueño;
   private String apellidoDueño;
}
