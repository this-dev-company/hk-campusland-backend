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
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
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

    List<Organizacion> organizaciones = proyectoRepository.findOrganizacionesByUsuarioId(userId);

    if (organizaciones.isEmpty()) {
        throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay organizaciones registradas a ese usuario");
    }

    List<OrganizacionDTO> organizacionDTOList = new ArrayList<>();

    for (Organizacion organizacion : organizaciones) {
        List<ProyectoDTO> proyectos = proyectoRepository.findProyectosByOrganizacionId(organizacion.getId());

        OrganizacionDTO organizacionDTO = new OrganizacionDTO(organizacion.getNombre(), proyectos);
        organizacionDTOList.add(organizacionDTO);
    }

    return organizacionDTOList;
}

}
