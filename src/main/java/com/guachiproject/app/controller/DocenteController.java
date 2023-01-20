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

import com.guachiproject.app.entity.Docente;
import com.guachiproject.app.service.DocenteService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/docente")
public class DocenteController {
	@Autowired
	DocenteService docenteService;
	
	@GetMapping("/listar")
    public ResponseEntity< List<Docente>> obtenerLista() {
        return new ResponseEntity<>(docenteService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Docente> crear(@Valid @RequestBody Docente c){
    	Docente chof= docenteService.save(c);
     return new ResponseEntity<>(chof,HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Docente> eliminar(@PathVariable Integer id) {
    	  docenteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Docente> actualizarUsuario(@PathVariable Integer id, @RequestBody Docente c) {
    	Docente docente = docenteService.findById(id);
        if (docente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	docente.setNombre(c.getNombre());
            	docente.setApellido(c.getApellido());
            	docente.setEmail(c.getEmail());
                return new ResponseEntity<>(docenteService.save(docente), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
}
