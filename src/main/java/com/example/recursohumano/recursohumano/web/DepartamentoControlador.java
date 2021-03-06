package com.example.recursohumano.recursohumano.web;
import java.util.List;
import java.util.Optional;

import com.example.recursohumano.recursohumano.model.Departamento;
import com.example.recursohumano.recursohumano.service.DepartamentoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Departamento")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class DepartamentoControlador {
    @Autowired
    private DepartamentoServicio departamentoServicio;

    @GetMapping("/all")
    public List<Departamento> getDepartamentos(){
        return departamentoServicio.getAll();
    }

    //El argumento @PathVariable indica que entra como una variable de la ruta el id y que se lo asigne a la variable id de la función
  
    @GetMapping("/{id}") 
    public Optional<Departamento>getDepartamento(@PathVariable("id") int id){
        return departamentoServicio.getDepartamento(id);

    }


    //@RequestBody le indica que lo que venga en el cuerpo de la petición lo ponga en el objeto dpto 
    // HttpStatus.CREATED indica la respuesta que será devuelta
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)   
    public Departamento save(@RequestBody Departamento dpto){
        return departamentoServicio.save(dpto);
    }

    
}
