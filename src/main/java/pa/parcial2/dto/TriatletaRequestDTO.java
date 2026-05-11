package pa.parcial2.dto;

import pa.parcial2.modelo.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TriatletaRequestDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String identificacion;

    @Min(7)
    private Integer edad;

    private Genero genero;

    @Email
    private String correo;

    private Especialidad especialidad;

    private Modalidad modalidad;

    private Boolean cross;

    private String foto;
}