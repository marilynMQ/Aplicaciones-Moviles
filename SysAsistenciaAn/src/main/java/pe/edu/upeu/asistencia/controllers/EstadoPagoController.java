/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.asistencia.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.asistencia.models.EstadoPago;
import pe.edu.upeu.asistencia.services.EstadoPagoService;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/asis/estadopago")
public class EstadoPagoController {
    @Autowired
    private EstadoPagoService entidadService;    
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<EstadoPago>> listEntidad() {
        List<EstadoPago> actDto = entidadService.findAll();
        return ResponseEntity.ok().body(actDto);
        //return new ResponseEntity<>(actDto, HttpStatus.OK);
    }    
     @PostMapping("/crear")
    public ResponseEntity<EstadoPago> createEstadoPago(@RequestBody EstadoPago EstadoPago) {
        EstadoPago data = entidadService.save(EstadoPago);
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<EstadoPago> geEntidadById(@PathVariable Long id) {
        EstadoPago EstadoPago = entidadService.geEntidadById(id);
        return ResponseEntity.ok(EstadoPago);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEstadoPago(@PathVariable Long id) {
        EstadoPago EstadoPago = entidadService.geEntidadById(id);
        return ResponseEntity.ok(entidadService.delete(EstadoPago.getId()));
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<EstadoPago> updateEstadoPago(@PathVariable Long id, @RequestBody EstadoPago EstadoPagoDetails) {        
        EstadoPago updatedEstadoPago = entidadService.update(EstadoPagoDetails, id);
        return ResponseEntity.ok(updatedEstadoPago);
    }   
}
