package fabrizio.armada.practica.dto;

import java.util.List;

import fabrizio.armada.practica.model.Tema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoTemaDTO {
   private String nombre;
   private List<Tema> listaTemas;
}
