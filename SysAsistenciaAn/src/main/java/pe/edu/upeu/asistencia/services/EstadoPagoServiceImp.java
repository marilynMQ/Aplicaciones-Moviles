/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.asistencia.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.asistencia.exceptions.ResourceNotFoundException;
import pe.edu.upeu.asistencia.models.EstadoPago;
import pe.edu.upeu.asistencia.repositories.EstadoPagoRepository;

/**
 *
 * @author DELL
 */
@RequiredArgsConstructor
@Service
@Transactional
public class EstadoPagoServiceImp implements EstadoPagoService {

    @Autowired
    private EstadoPagoRepository entidadRepo;

    @Override
    public EstadoPago save(EstadoPago entidad) {
        return entidadRepo.save(entidad);
    }

    @Override
    public List<EstadoPago> findAll() {
        return entidadRepo.findAll();
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        EstadoPago entidadx = entidadRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoPago not exist with id :" + id));
        entidadRepo.delete(entidadx);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public EstadoPago geEntidadById(Long id) {
        EstadoPago findEntidad = entidadRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("EstadoPago not exist with id :" + id));
        return findEntidad;
    }

    @Override
    public EstadoPago update(EstadoPago entidad, Long id) {
        EstadoPago entidadx = entidadRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo not exist with id :" + id));
        entidadx.setNombre(entidad.getNombre());
        entidadx.setDescripcion(entidad.getDescripcion());
        return entidadRepo.save(entidadx);
    }

}
