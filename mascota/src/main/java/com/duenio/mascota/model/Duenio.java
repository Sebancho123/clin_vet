
package com.duenio.mascota.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Duenio {
    
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id_duenio;
    private String dni;
    private String nombre;
    private String apellido; 
    private String cecular;
    
    public Duenio() {
    }

    public Duenio(Long id_duenio, String dni, String nombre, String apellido, String cecular) {
        this.id_duenio = id_duenio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cecular = cecular;
    }

   
    
    
}
