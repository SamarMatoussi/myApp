package com.kpi.bank.form;

import com.kpi.bank.entites.Departement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartementFrom {
    private String nameDep;

    public DepartementFrom(Departement departement) {

        this.nameDep = departement.getName();
    }

    public DepartementFrom() {
    }
}
