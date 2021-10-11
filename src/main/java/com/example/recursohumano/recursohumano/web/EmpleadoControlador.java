package com.example.recursohumano.recursohumano.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.recursohumano.recursohumano.service.EmpleadoServicio;
import com.example.recursohumano.recursohumano.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleado")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/all")
    public List<Empleado> getEmpleados(){
        return empleadoServicio.getAll();
    }

    //El argumento @PathVariable indica que entra como una variable de la ruta el id y que se lo asigne a la variable id de la función
  
    @GetMapping("/{id}") 
    public Optional<Empleado>getEmpleado(@PathVariable("id") int id){
        return empleadoServicio.getEmpleado(id);

    }


    //@RequestBody le indica que lo que venga en el cuerpo de la petición lo ponga en el objeto dpto 
    // HttpStatus.CREATED indica la respuesta que será devuelta
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)   
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoServicio.save(empleado);
        
       
    }

    
}
