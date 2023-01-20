package com.guachiproject.app.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "asignatura")
@Data
public class Asignatura {

	@Id
	@Column(name = "id_asignatura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_asignatura;

	private String nombre;

	private String carrera;

	private String hora_ini;

	private String hora_fin;

	@ManyToOne
	@JoinColumn(name = "id_docente", referencedColumnName = "id_docente")
	private Docente docente;
}
