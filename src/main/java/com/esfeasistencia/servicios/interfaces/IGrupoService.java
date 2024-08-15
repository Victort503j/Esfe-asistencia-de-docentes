package com.esfeasistencia.servicios.interfaces;

import com.esfeasistencia.modelos.Grupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGrupoService {
    Page<Grupo> buscarTodosPaginados(Pageable pageable);

    List<Grupo> obtenerTodos();

    Optional<Grupo> buscarPorId(Integer id);

    Grupo crearOEditar(Grupo grupo);

    void elimanarPorId(Integer id);
}