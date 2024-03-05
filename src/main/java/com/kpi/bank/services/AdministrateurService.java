package com.kpi.bank.services;


import com.kpi.bank.entites.Administrateur;
import com.kpi.bank.form.AdministrateurForm;

import java.util.List;
import java.util.Map;

public interface AdministrateurService {
    public Administrateur addAdministrateur(AdministrateurForm form);
    public Administrateur updateAdministrateur(Long id, AdministrateurForm form);
    public Administrateur getAdministrateur(Long id);
    public Map<String,Boolean> deleteAdministrateur(Long id);
    public List<Administrateur> getAdministrateurs();

}
