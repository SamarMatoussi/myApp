package com.kpi.bank.dto;


import com.kpi.bank.entites.Administrateur;
import com.kpi.bank.form.AdministrateurForm;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AdministrateurDto extends AdministrateurForm {
    private Long id;

    public AdministrateurDto(Administrateur administrateur) {
        super(administrateur);
        this.id = administrateur.getId();
    }

    public static AdministrateurDto of(Administrateur administrateur){
        return new AdministrateurDto(administrateur);
    }

    public static List<AdministrateurDto> of(List<Administrateur> administrateurs){
        return administrateurs.stream().map(AdministrateurDto::of).collect(Collectors.toList());
    }
}
