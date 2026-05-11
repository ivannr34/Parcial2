package pa.parcial2.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "triatletas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Triatleta extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(nullable = false)
    private String correo;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Enumerated(EnumType.STRING)
    private Modalidad modalidad;

    private Boolean cross;

    @Lob
    private String foto;
}