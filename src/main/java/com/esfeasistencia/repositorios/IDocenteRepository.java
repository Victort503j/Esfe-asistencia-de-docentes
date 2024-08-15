package com.esfeasistencia.repositorios;

import com.esfeasistencia.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteRepository extends JpaRepository<Docente, Integer> {
}
