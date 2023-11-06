/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.asistencia.services;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.asistencia.models.EstadoPago;

/**
 *
 * @author DELL
 */
public interface EstadoPagoService {
    EstadoPago save(EstadoPago entidad);

    List<EstadoPago> findAll();

    Map<String, Boolean> delete(Long id);

    EstadoPago geEntidadById(Long id);

    EstadoPago update(EstadoPago entidad, Long id); 
}
