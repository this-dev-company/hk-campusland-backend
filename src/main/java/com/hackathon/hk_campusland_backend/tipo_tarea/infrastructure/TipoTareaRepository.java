package com.hackathon.hk_campusland_backend.tipo_tarea.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.hk_campusland_backend.tipo_tarea.domain.entity.TipoTarea;

public interface TipoTareaRepository extends JpaRepository<TipoTarea, Long> {

}
