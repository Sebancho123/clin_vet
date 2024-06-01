
package com.duenio.mascota.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaDTO {
    
    private String nombre;
    private String especie;
    private String raza;
    private String nombreDuenio;
    private String apellido;

    public MascotaDTO() {
    }

    public MascotaDTO(String nombre, String especie, String raza, String nombreDuenio, String apellido) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.nombreDuenio = nombreDuenio;
        this.apellido = apellido;
    }
    
}
