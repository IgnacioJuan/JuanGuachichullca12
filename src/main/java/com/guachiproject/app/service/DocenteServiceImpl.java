package com.guachiproject.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.guachiproject.app.entity.Docente;
import com.guachiproject.app.repository.DocenteRepository;

@Service
public class DocenteServiceImpl extends GenericServiceImpl<Docente, Integer> implements DocenteService{

	@Autowired
	DocenteRepository docenteRepository;
	
	@Override
	public CrudRepository<Docente, Integer> getDao() {
		// TODO Auto-generated method stub
		return docenteRepository;
	}

}
