package com.example.recursohumano.recursohumano.repository;

import com.example.recursohumano.recursohumano.model.Empleado;
import com.example.recursohumano.recursohumano.repository.crud.EmpleadoCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoRepositorio {
    @Autowired
    private EmpleadoCrudRepositorio empleadoCrudRepositorio;

    public List<Empleado> getAll(){
        return (List<Empleado>) empleadoCrudRepositorio.findAll();        
    }

    public Optional<Empleado>getEmpleado(int id){
        return empleadoCrudRepositorio.findById(id);
    }
    
    public Empleado save(Empleado empleado){
        return empleadoCrudRepositorio.save(empleado);
    }


    
}
