package com.esfeasistencia.repositorios;

import com.esfeasistencia.modelos.DocenteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteGrupoRepository extends JpaRepository<DocenteGrupo, Integer> {
    Page<DocenteGrupo> findByOrderByDocenteDesc(Pageable pageable);
}
