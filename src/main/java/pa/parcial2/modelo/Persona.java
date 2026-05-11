package pa.parcial2.modelo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Persona {

    @Column(nullable = false)
    protected String nombre;

    @Column(unique = true, nullable = false)
    protected String identificacion;

    @Column(nullable = false)
    protected Integer edad;

    @Enumerated(EnumType.STRING)
    protected Genero genero;

}