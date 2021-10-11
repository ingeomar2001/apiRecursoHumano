package com.example.recursohumano.recursohumano.repository;

import com.example.recursohumano.recursohumano.model.Departamento;
import com.example.recursohumano.recursohumano.repository.crud.DepartamentoCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class DepartamentoRepositorio {

    @Autowired
    private DepartamentoCrudRepositorio departamentoCrudRepositorio;
    
    public List<Departamento> getAll(){
        return (List<Departamento>) departamentoCrudRepositorio.findAll();        
    }

    public Optional<Departamento>getDepartamento(int id){
        return departamentoCrudRepositorio.findById(id);
    }
    
    public Departamento save(Departamento dpto){
        return departamentoCrudRepositorio.save(dpto);
    }
    
}
