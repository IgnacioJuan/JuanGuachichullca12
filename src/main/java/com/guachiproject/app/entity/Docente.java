package com.guachiproject.app.entity;

import jakarta.persistence.Entity;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "docente")
public class Docente {
	
	@Id
	@Column(name="id_docente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_docente;
	
	@Column(length = 50)
    @NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
	private String nombre;
	
	private String apellido;
	
	private String celular;
	
	private String email;
	
	@JsonIgnore
    @OneToMany(mappedBy = "docente")
    private List<Asignatura> asignaturas;
}
