package com.hackathon.hk_campusland_backend.proyectos.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;
import com.hackathon.hk_campusland_backend.proyectos.domain.dto.OrganizacionDTO;
import com.hackathon.hk_campusland_backend.proyectos.domain.dto.ProyectoDTO;
import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;
import com.hackathon.hk_campusland_backend.proyectos.domain.service.ProyectoInterface;
import com.hackathon.hk_campusland_backend.proyectos.infrastructure.ProyectoRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import jakarta.transaction.Transactional;

@Service
public class ProyectoServiceImpl implements ProyectoInterface {

    @Autowired
    ProyectoRepository proyectoRepository;

    @Override
    @Transactional
    public void save(Proyecto proyecto) {
         proyectoRepository.save(proyecto);
    }

    @Override
    @Transactional
    public void delete(Proyecto proyecto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @Transactional
    public void update(Long id, Proyecto proyecto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    @Transactional
    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Proyecto> findById(Long id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public List<OrganizacionDTO> findProyectsByUserId(long userId) {
    // Obtener las organizaciones asociadas al usuario
    List<Organizacion> organizaciones = proyectoRepository.findOrganizacionesByUsuarioId(userId);

    if (organizaciones.isEmpty()) {
        throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay organizaciones registradas a ese usuario");
    }

    // Crear la lista de OrganizacionDTO
    List<OrganizacionDTO> organizacionDTOList = new ArrayList<>();

    // Iterar por cada organización y obtener sus proyectos
    for (Organizacion organizacion : organizaciones) {
        // Obtener los proyectos de la organización
        List<ProyectoDTO> proyectos = proyectoRepository.findProyectosByOrganizacionId(organizacion.getId());

        // Crear el DTO de la organización con sus proyectos
        OrganizacionDTO organizacionDTO = new OrganizacionDTO(organizacion.getNombre(), proyectos);
        organizacionDTOList.add(organizacionDTO);
    }

    return organizacionDTOList;
}

}
