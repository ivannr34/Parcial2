package pa.parcial2.service.implementacion;

import pa.parcial2.dto.TriatletaRequestDTO;
import pa.parcial2.modelo.*;
import pa.parcial2.repository.TriatletaRepository;
import pa.parcial2.service.EmailService;
import pa.parcial2.service.TriatletaService;
import pa.parcial2.util.CategoriaUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TriatletaServiceImpl implements TriatletaService {

    private final TriatletaRepository repository;
    private final EmailService emailService;

    @Override
    public Triatleta registrar(TriatletaRequestDTO dto) {
        Triatleta triatleta = Triatleta.builder()
                .correo(dto.getCorreo())
                .categoria(CategoriaUtil.calcularCategoria(dto.getEdad()))
                .especialidad(dto.getEspecialidad())
                .modalidad(dto.getModalidad())
                .cross(dto.getCross())
                .foto(dto.getFoto())
                .build();
        triatleta.setNombre(dto.getNombre());
        triatleta.setEdad(dto.getEdad());
        triatleta.setGenero(dto.getGenero());
        triatleta.setIdentificacion(dto.getIdentificacion());
        Triatleta guardado = repository.save(triatleta);
        emailService.enviarCorreoRegistro(
                guardado.getCorreo(),
                guardado.getNombre()
        );
        return guardado;
    }

    @Override
    public Triatleta buscarPorIdentificacion(String identificacion) {
        return repository.findByIdentificacion(identificacion)
                .orElseThrow();
    }

    @Override
    public List<Triatleta> listarPorGenero(Genero genero) {
        return repository.findByGenero(genero);
    }

    @Override
    public List<Triatleta> listarPorCategoria(Categoria categoria) {
        return repository.findByCategoria(categoria);
    }

    @Override
    public List<Triatleta> listarPorEspecialidad(Especialidad especialidad) {
        return repository.findByEspecialidad(especialidad);
    }

    @Override
    public List<Triatleta> listarPorCross(Boolean cross) {
        return repository.findByCross(cross);
    }

    @Override
    public Triatleta actualizarNombre(Long id, String nombre) {
        Triatleta t = repository.findById(id).orElseThrow();
        t.setNombre(nombre);
        return repository.save(t);
    }

    @Override
    public Triatleta actualizarIdentificacion(Long id, String identificacion) {
        Triatleta t = repository.findById(id).orElseThrow();
        t.setIdentificacion(identificacion);
        return repository.save(t);
    }

    @Override
    public Triatleta actualizarCategoria(Long id, Categoria categoria) {
        Triatleta t = repository.findById(id).orElseThrow();
        t.setCategoria(categoria);
        return repository.save(t);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
