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
import pe.edu.upeu.asistencia.models.Facultad;
import pe.edu.upeu.asistencia.services.FacultadService;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/asis/facultad")
public class FacultadController {
    @Autowired
    private FacultadService entidadService;    
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Facultad>> listEntidad() {
        List<Facultad> actDto = entidadService.findAll();
        return ResponseEntity.ok().body(actDto);
        //return new ResponseEntity<>(actDto, HttpStatus.OK);
    }    
     @PostMapping("/crear")
    public ResponseEntity<Facultad> createFacultad(@RequestBody Facultad facultad) {
        Facultad data = entidadService.save(facultad);
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Facultad> geEntidadById(@PathVariable Long id) {
        Facultad facultad = entidadService.geEntidadById(id);
        return ResponseEntity.ok(facultad);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFacultad(@PathVariable Long id) {
        Facultad facultad = entidadService.geEntidadById(id);
        return ResponseEntity.ok(entidadService.delete(facultad.getId()));
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<Facultad> updateFacultad(@PathVariable Long id, @RequestBody Facultad facultadDetails) {        
        Facultad updatedFacultad = entidadService.update(facultadDetails, id);
        return ResponseEntity.ok(updatedFacultad);
    }   
}
