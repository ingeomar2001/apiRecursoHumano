package com.example.recursohumano.recursohumano.service;

import java.util.List;
import java.util.Optional;
import com.example.recursohumano.recursohumano.model.Departamento;
import com.example.recursohumano.recursohumano.repository.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServicio {
    
    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    public List<Departamento> getAll(){
        return departamentoRepositorio.getAll();             
    }

    public Optional<Departamento>getDepartamento(int id){
        return departamentoRepositorio.getDepartamento(id);
    }

    public Departamento save(Departamento dpto){
        /*
        Verifico si el numId es null quiere decir que es nuevo lo guardo
        */ 
        //System.out.println(dpto);
        if(dpto.getNumId()==null){
            
            return departamentoRepositorio.save(dpto);
        }else{
            Optional<Departamento> consulta=departamentoRepositorio.getDepartamento(dpto.getNumId());
            if(consulta.isEmpty()){
                return departamentoRepositorio.save(dpto);
            }else{
                return dpto;
            }
        }


    }

}
