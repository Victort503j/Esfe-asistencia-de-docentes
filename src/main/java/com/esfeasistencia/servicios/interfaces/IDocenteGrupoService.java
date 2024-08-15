package com.esfeasistencia.servicios.interfaces;

import com.esfeasistencia.modelos.DocenteGrupo;
import org.springframework.data.domain.Page;


import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IDocenteGrupoService {

    List<DocenteGrupo> obtenerTodos();

    Page<DocenteGrupo> buscarTodosPaginados(Pageable pageable);

    DocenteGrupo buscarPorId(Integer id);

    DocenteGrupo crearOEditar(DocenteGrupo docenteGrupo);

    void eliminarPorId(Integer id);
}
