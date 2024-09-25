package com.hackathon.hk_campusland_backend.tipo_tarea.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.tipo_tarea.domain.entity.TipoTarea;
import com.hackathon.hk_campusland_backend.tipo_tarea.domain.service.TipoTareaInterface;
import com.hackathon.hk_campusland_backend.tipo_tarea.infrastructure.TipoTareaRepository;

import jakarta.transaction.Transactional;

@Service
public class TipoTareaServiceImpl implements TipoTareaInterface {

    @Autowired
    TipoTareaRepository tipoTareaRepository;

    @Override
    @Transactional
    public void save(TipoTarea tipoTarea) {
        tipoTareaRepository.save(tipoTarea);
    }

    @Override
    @Transactional
    public void delete(TipoTarea tipoTarea) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @Transactional
    public void update(Long id, TipoTarea tipoTarea) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    @Transactional
    public List<TipoTarea> findAll() {
        return tipoTareaRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<TipoTarea> findById(Long id) {
        return tipoTareaRepository.findById(id);
    }

}
