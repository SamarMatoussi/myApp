package com.kpi.bank.dto;

import com.kpi.bank.entites.Client;
import com.kpi.bank.entites.Departement;
import com.kpi.bank.form.DepartementFrom;

import java.util.List;
import java.util.stream.Collectors;

public class DepartementDto extends DepartementFrom {
    private Long id;


    public DepartementDto(Departement departement) {
        super(departement);
        this.id = departement.getId();
    }
    public static DepartementDto of(Departement departement)
    {
        return new DepartementDto(departement);
    }

    public static List<DepartementDto> of(List<Departement> departements){
        return departements.stream().map(DepartementDto::of).collect(Collectors.toList());
    }
}
