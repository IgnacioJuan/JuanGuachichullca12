package com.guachiproject.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guachiproject.app.entity.Asignatura;
import com.guachiproject.app.service.AsignaturaService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController {
	@Autowired
	AsignaturaService asignaturaService;
	
	@GetMapping("/listar")
    public ResponseEntity< List<Asignatura>> obtenerLista() {
        return new ResponseEntity<>(asignaturaService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Asignatura> crear(@Valid @RequestBody Asignatura c){
    	Asignatura asig= asignaturaService.save(c);
     return new ResponseEntity<>(asig,HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Asignatura> eliminar(@PathVariable Integer id) {
    	  asignaturaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Asignatura> actualizarUsuario(@PathVariable Integer id, @RequestBody Asignatura c) {
    	Asignatura asignatura = asignaturaService.findById(id);
        if (asignatura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	asignatura.setCarrera(c.getCarrera());
            	asignatura.setHora_fin(c.getHora_fin());
            	asignatura.setHora_ini(c.getHora_ini());
            	asignatura.setNombre(c.getNombre());
                return new ResponseEntity<>(asignaturaService.save(asignatura), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
}
