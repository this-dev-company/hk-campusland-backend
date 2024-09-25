package com.hackathon.hk_campusland_backend.equipos.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.equipos.domain.entity.Equipo;
import com.hackathon.hk_campusland_backend.equipos.domain.services.EquipoService;
import com.hackathon.hk_campusland_backend.equipos.infrastructure.repositories.EquipoRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public Optional<Equipo> findById(Long id) {

        if (!equipoRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El Equipo no existe");
        }

        return equipoRepository.findById(id);
    }

    @Override
    public List<Equipo> getAll() {
        List<Equipo> equipos = equipoRepository.findAll();

        if (equipos.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay Equipos registrados");
        }

        return equipoRepository.findAll();
    }

    @Override
    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }
}
