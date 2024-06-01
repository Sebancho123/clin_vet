package com.duenio.mascota.service;

import com.duenio.mascota.dto.MascotaDTO;
import com.duenio.mascota.model.Mascota;
import com.duenio.mascota.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository iMascoRepo;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = iMascoRepo.findAll();
        return listaMascotas;

    }

    @Override
    public void saveMascota(Mascota masco) {
        iMascoRepo.save(masco);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        iMascoRepo.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_masco) {
        return iMascoRepo.findById(id_masco).orElse(null);
    }

    @Override
    public Mascota editarMascota(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
        Mascota masco = this.findMascota(idOriginal);

        masco.setId_mascota(idNueva);
        masco.setNombre(nuevoNombre);
        masco.setEspecie(nuevaEspecie);
        masco.setRaza(nuevaRaza);
        masco.setColor(nuevoColor);

        this.saveMascota(masco);
        return masco;

    }

    @Override
    public Mascota editMascota(Mascota masco) {
        this.saveMascota(masco);
        return masco;
    }

    @Override
    public List<Mascota> getEspePeRaCani() {

        String especie = "perro";
        String especieCompa;
        String raza = "caniche";
        String razaCompa;

        List<Mascota> listaMascotas = this.getMascotas();
        List<Mascota> listaMasEspeRaza = new ArrayList<Mascota>();

        for (Mascota masco : listaMascotas) {
            especieCompa = masco.getEspecie();
            razaCompa = masco.getRaza();
            
            boolean siEsEspeONo = especieCompa.contains(especie);
            boolean siEsRazaOno  = razaCompa.contains(raza);
            
            if (siEsEspeONo = true && siEsRazaOno == true) {
                listaMasEspeRaza.add(masco);
            }
        }
        
        return listaMasEspeRaza;

    }

    @Override
    public MascotaDTO getMascoDto(Long id_masco) {
        
        MascotaDTO mascoDto = new MascotaDTO();
        Mascota masco = this.findMascota(id_masco);
        
        mascoDto.setNombre(masco.getNombre());
        mascoDto.setEspecie(masco.getEspecie());
        mascoDto.setRaza(masco.getRaza());
        mascoDto.setNombreDuenio(masco.getUnDuenio().getNombre());
        mascoDto.setApellido(masco.getUnDuenio().getApellido());
        
        return mascoDto;
        
    }

}
