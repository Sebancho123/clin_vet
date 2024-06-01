
package com.duenio.mascota.service;

import com.duenio.mascota.model.Duenio;
import com.duenio.mascota.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenioService implements IDuenioService{
    
    @Autowired
    private IDuenioRepository iDueRepo;

    @Override
    public List<Duenio> getDuenios() {
        
        List<Duenio> listaDuenios = iDueRepo.findAll();
        return listaDuenios;
        
    }

    @Override
    public void saveDuenio(Duenio duenio) {
        iDueRepo.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id_duenio) {
        iDueRepo.deleteById(id_duenio);
    }

    @Override
    public Duenio findDuenio(Long id_duenio) {
        return iDueRepo.findById(id_duenio).orElse(null);
    }

    @Override
    public Duenio editarDuenio(Long idoriginal, Long idNueva, String nuevoDni, String nuevoNombre, String nuevoApellido, String nuevoCelular) {
        
        Duenio duenio = this.findDuenio(idoriginal);
        
        duenio.setId_duenio(idNueva);
        duenio.setDni(nuevoDni);
        duenio.setNombre(nuevoNombre);
        duenio.setApellido(nuevoApellido);
        duenio.setCecular(nuevoCelular);
        
        this.saveDuenio(duenio);
        
        return duenio;
        
    }

    @Override
    public Duenio editDuenio(Duenio duenio) {
        this.saveDuenio(duenio);
        return duenio;
    }
    
}
