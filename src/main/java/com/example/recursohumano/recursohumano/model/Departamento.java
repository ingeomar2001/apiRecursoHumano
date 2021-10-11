package com.example.recursohumano.recursohumano.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="departamento")
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private String nombreDepartamento;

    //Realizamos la relación
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "departamento")
    @JsonIgnoreProperties("departamento") //Para que ignore el atributo departamento
    private List<Empleado> empleados;
    
    public Integer getNumId() {
        return numId;
    }
    public void setNumId(Integer numId) {
        this.numId = numId;
    }
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    @Override
    public String toString() {
        return "Departamento [nombreDepartamento=" + nombreDepartamento + ", numId=" + numId + "]";
    }

    
    
}
