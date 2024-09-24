package com.hackathon.hk_campusland_backend.tipo_tarea.domain.service;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.tipo_tarea.domain.entity.TipoTarea;

public interface TipoTareaInterface {
    void save(TipoTarea tipoTarea);
    void delete(TipoTarea tipoTarea);
    void update(Long id, TipoTarea tipoTarea);
    List<TipoTarea>  findAll();
    Optional<TipoTarea> findById(Long id);
}
