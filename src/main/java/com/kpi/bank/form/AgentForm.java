package com.kpi.bank.form;

import com.kpi.bank.entites.Agent;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentForm {
    @NotEmpty(message = "firstname is required")
    @Size(min=3,max =30,message = "length of firstname should be between 3 and 10")
    @Pattern(regexp = "[a-zA-Z]+",message="firstname can not contains numbers")
    @Column(name = "firstname",length = 30,nullable = false,unique = true)
    private String firstname;
    @NotEmpty(message = "lastname is required")
    @Size(min=3,max =30,message = "length of lastname should be between 3 and 10")
    @Pattern(regexp = "[a-zA-Z]+",message="lastname can not contains numbers")
    private String lastname;
    @NotEmpty(message = "email is required")
    @Email
    private String email;
    @NotEmpty(message = "phone is required")
    @Size(min=3,max =13,message = "length of phone should be between 3 and 10")
    @Pattern(regexp = "[0-9]+",message="phone can not contains caracters")
    private String phone;

    public AgentForm() {
    }

    public AgentForm(Agent agent) {
        this.firstname = agent.getPrenom();
        this.lastname = agent.getNom();
        this.email = agent.getEmail();
        this.phone = agent.getPhone();
    }
}
