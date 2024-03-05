package com.kpi.bank.services;
import com.kpi.bank.entites.Administrateur;
import com.kpi.bank.form.AdministrateurForm;
import com.kpi.bank.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdministrateurServiceImpl implements AdministrateurService {

    @Autowired
    AdministrateurRepository administrateurRepository;


    @Override
    public Administrateur addAdministrateur(AdministrateurForm form) {
        Administrateur administrateur = new Administrateur();
        administrateur.setNom(form.getLastname());
        administrateur.setPrenom(form.getFirstname());
        administrateur.setEmail(form.getEmail());
        administrateur.setPhone(form.getPhone());
        return administrateurRepository.save(administrateur);

    }

    @Override
    public Administrateur updateAdministrateur(Long id, AdministrateurForm form) {
        Administrateur administrateur = getAdministrateur(id);
        administrateur.setNom(form.getLastname());
        administrateur.setPrenom(form.getFirstname());
        administrateur.setEmail(form.getEmail());
        administrateur.setPhone(form.getPhone());
        return administrateurRepository.save(administrateur);
    }

    @Override
    public Administrateur getAdministrateur(Long id) {
        Optional<Administrateur> administrateur = administrateurRepository.findById(id);
        return administrateur.get();
    }

    @Override
    public Map<String, Boolean> deleteAdministrateur(Long id) {
        Administrateur administrateur = getAdministrateur(id);
        administrateurRepository.delete(administrateur);
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted",Boolean.TRUE);
        return map;
    }

    @Override
    public List<Administrateur> getAdministrateurs() {

        return administrateurRepository.findAll();
    }

}
