package pa.parcial2.repository;

import pa.parcial2.modelo.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TriatletaRepository extends JpaRepository<Triatleta, Long> {

    Optional<Triatleta> findByIdentificacion(String identificacion);

    List<Triatleta> findByGenero(Genero genero);

    List<Triatleta> findByCategoria(Categoria categoria);

    List<Triatleta> findByEspecialidad(Especialidad especialidad);

    List<Triatleta> findByCross(Boolean cross);
}