package com.example.recursohumano.recursohumano.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private String nombre;
    private Integer edad;
    private String ciudad;
    private Integer salario;


    //Realizamos la relación
    @ManyToOne
    @JoinColumn(name="departamento_id")
    @JsonIgnoreProperties("empleados") //Para que ignore el atributo empleados
    private Departamento departamento;

    public Integer getNumId() {
        return numId;
    }
    public void setNumId(Integer numId) {
        this.numId = numId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Integer getSalario() {
        return salario;
    }
    public void setSalario(Integer salario) {
        this.salario = salario;
    }
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    @Override
    public String toString() {
        return "Empleado [ciudad=" + ciudad + ", departamento=" + departamento + ", edad=" + edad + ", nombre=" + nombre
                + ", numId=" + numId + ", salario=" + salario + "]";
    }

    

    
    
}
