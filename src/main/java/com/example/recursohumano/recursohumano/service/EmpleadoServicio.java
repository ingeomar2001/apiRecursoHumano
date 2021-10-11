package com.example.recursohumano.recursohumano.service;

import com.example.recursohumano.recursohumano.model.Empleado;
import com.example.recursohumano.recursohumano.repository.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EmpleadoServicio {
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    public List<Empleado> getAll(){
        return empleadoRepositorio.getAll();             
    }

    public Optional<Empleado>getEmpleado(int id){
        return empleadoRepositorio.getEmpleado(id);
    }

    public Empleado save(Empleado empleado){
        /*
        Verifico si el numId es null quiere decir que es nuevo lo guardo
        */ 
        System.out.println(empleado);
        
        if(empleado.getNumId()==null){
            return empleadoRepositorio.save(empleado);
        }else{
            Optional<Empleado> consulta=empleadoRepositorio.getEmpleado(empleado.getNumId());
            if(consulta.isEmpty()){
                return empleadoRepositorio.save(empleado);
            }else{
                return empleado;
            }
        }


    }
}
