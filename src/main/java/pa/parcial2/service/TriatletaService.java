package pa.parcial2.service;

import pa.parcial2.dto.TriatletaRequestDTO;
import pa.parcial2.modelo.*;

import java.util.List;

public interface TriatletaService {

    Triatleta registrar(TriatletaRequestDTO dto);

    Triatleta buscarPorIdentificacion(String identificacion);

    List<Triatleta> listarPorGenero(Genero genero);

    List<Triatleta> listarPorCategoria(Categoria categoria);

    List<Triatleta> listarPorEspecialidad(Especialidad especialidad);

    List<Triatleta> listarPorCross(Boolean cross);

    Triatleta actualizarNombre(Long id, String nombre);

    Triatleta actualizarIdentificacion(Long id, String identificacion);

    Triatleta actualizarCategoria(Long id, Categoria categoria);

    void eliminar(Long id);
}