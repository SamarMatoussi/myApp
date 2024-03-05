package com.kpi.bank.services;

import com.kpi.bank.entites.Departement;
import com.kpi.bank.form.DepartementFrom;

import java.util.List;
import java.util.Map;

public interface DepartementService {

    public Departement addDepartement(DepartementFrom form);
    public Departement updateDepartement(Long id, DepartementFrom form);
    public Departement getDepartement(Long id);
    public Map<String,Boolean> deleteDepartement(Long id);
    public List<Departement> getDepartement();
}
