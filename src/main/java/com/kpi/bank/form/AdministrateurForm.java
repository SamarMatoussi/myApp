package com.kpi.bank.form;

import com.kpi.bank.entites.Administrateur;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdministrateurForm {
    @NotEmpty(message = "firstname is required")
    @Size(min=3,max =10,message = "length of firstname should be between 3 and 10")
    @Pattern(regexp = "[a-zA-Z]+",message="firstname can not contains numbers")
    private String firstname;
    @NotEmpty(message = "lastname is required")
    @Size(min=3,max =10,message = "length of lastname should be between 3 and 10")
    @Pattern(regexp = "[a-zA-Z]+",message="lastname can not contains numbers")
    private String lastname;
    @NotEmpty(message = "email is required")
    @Email
    private String email;
    @NotEmpty(message = "phone is required")
    @Size(min=3,max =13,message = "length of phone should be between 3 and 10")
    @Pattern(regexp = "[0-9]+",message="phone can not contains caracters")
    private String phone;
    public AdministrateurForm() {
    }


    public AdministrateurForm(Administrateur administrateur) {
        this.firstname = administrateur.getPrenom();
        this.lastname = administrateur.getNom();
        this.email = administrateur.getEmail();
        this.phone = administrateur.getPhone();

    }
}
