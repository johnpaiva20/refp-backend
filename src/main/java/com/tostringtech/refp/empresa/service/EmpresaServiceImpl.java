package com.tostringtech.refp.empresa.service;

import com.tostringtech.refp.application.model.Empresa;
import com.tostringtech.refp.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;


    @Override
	public List<Empresa> findAll() {
		return (List<Empresa>) empresaRepository.findAll();
	}
    @Override
    public Optional<Empresa> findById(Long codigo) {
        //Empresa empresa = empresaRepository.findById(codigo);
        return empresaRepository.findById(codigo);
    }

    @Override
    public Page<Empresa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return null;
    }

    @Override
    public Empresa create (Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public Empresa update(Empresa empresa) {
        findById(empresa.getCodigo());
        return empresaRepository.save(empresa);
    }
    @Override
    public void delete(Long codigo)  {
        findById(codigo);
        empresaRepository.deleteById(codigo);
    }

}
