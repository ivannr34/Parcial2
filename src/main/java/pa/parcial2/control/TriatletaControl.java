package pa.parcial2.control;

import pa.parcial2.dto.TriatletaRequestDTO;
import pa.parcial2.modelo.*;
import pa.parcial2.service.TriatletaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/triatletas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class TriatletaControl {

    private final TriatletaService service;

    @RequestMapping(method = RequestMethod.POST)
    public Triatleta registrar(
            @Valid @RequestBody TriatletaRequestDTO dto
    ) {
        return service.registrar(dto);
    }

    @RequestMapping(value = "/identificacion/{identificacion}",
            method = RequestMethod.GET)
    public Triatleta buscar(
            @PathVariable String identificacion
    ) {
        return service.buscarPorIdentificacion(identificacion);
    }

    @RequestMapping(value = "/genero/{genero}",
            method = RequestMethod.GET)
    public List<Triatleta> porGenero(
            @PathVariable Genero genero
    ) {
        return service.listarPorGenero(genero);
    }

    @RequestMapping(value = "/categoria/{categoria}",
            method = RequestMethod.GET)
    public List<Triatleta> porCategoria(
            @PathVariable Categoria categoria
    ) {
        return service.listarPorCategoria(categoria);
    }

    @RequestMapping(value = "/especialidad/{especialidad}",
            method = RequestMethod.GET)
    public List<Triatleta> porEspecialidad(
            @PathVariable Especialidad especialidad
    ) {
        return service.listarPorEspecialidad(especialidad);
    }

    @RequestMapping(value = "/cross/{cross}",
            method = RequestMethod.GET)
    public List<Triatleta> porCross(
            @PathVariable Boolean cross
    ) {
        return service.listarPorCross(cross);
    }

    @RequestMapping(value = "/{id}/nombre",
            method = RequestMethod.PATCH)
    public Triatleta actualizarNombre(
            @PathVariable Long id,
            @RequestParam String nombre
    ) {
        return service.actualizarNombre(id, nombre);
    }

    @RequestMapping(value = "/{id}/identificacion",
            method = RequestMethod.PATCH)
    public Triatleta actualizarIdentificacion(
            @PathVariable Long id,
            @RequestParam String identificacion
    ) {
        return service.actualizarIdentificacion(id, identificacion);
    }

    @RequestMapping(value = "/{id}/categoria",
            method = RequestMethod.PATCH)
    public Triatleta actualizarCategoria(
            @PathVariable Long id,
            @RequestParam Categoria categoria
    ) {
        return service.actualizarCategoria(id, categoria);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
