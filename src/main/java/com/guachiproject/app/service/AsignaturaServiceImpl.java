package com.guachiproject.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.guachiproject.app.entity.Asignatura;
import com.guachiproject.app.repository.AsignaturaRepository;

@Service
public class AsignaturaServiceImpl extends GenericServiceImpl<Asignatura, Integer> implements AsignaturaService{
	
	@Autowired
	AsignaturaRepository asignaturaRepository;
	@Override
	public CrudRepository<Asignatura, Integer> getDao() {
		// TODO Auto-generated method stub
		return asignaturaRepository;
	}

}
