package com.kpi.bank.controller;


import com.kpi.bank.dto.AdministrateurDto;
import com.kpi.bank.entites.Administrateur;
import com.kpi.bank.form.AdministrateurForm;
import com.kpi.bank.services.AdministrateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
//@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AdministrateurController {
    @Autowired
    AdministrateurService administrateurService;
    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/administrateur")
    public AdministrateurDto addAdministrateur(@Valid @RequestBody AdministrateurForm form){
        Administrateur administrateur =  administrateurService.addAdministrateur(form);
        return AdministrateurDto.of(administrateur);
    }

    @PreAuthorize("hasAuthority('admin:read')")
    @GetMapping("/administrateurs")
    public List<AdministrateurDto> getAll(){
        List<Administrateur> administrateurs = administrateurService.getAdministrateurs();
        return AdministrateurDto.of(administrateurs);
    }


    @PreAuthorize("hasAuthority('admin:read')")
    @GetMapping("/administrateur/{id}")
    public AdministrateurDto getAdministrateur(@PathVariable("id") long administrateurId){
        Administrateur administrateur = administrateurService.getAdministrateur(administrateurId);
        return AdministrateurDto.of(administrateur);
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/administrateur/{id}")
    public Map<String,Boolean> deleteAdministrateur(@PathVariable("id") long administrateurId){
        return administrateurService.deleteAdministrateur(administrateurId);

    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/administrateur/{id}")
    public AdministrateurDto updateAdministrateur(@PathVariable("id") long administrateurId,@Valid @RequestBody AdministrateurForm form){
        Administrateur administrateur = administrateurService.updateAdministrateur(administrateurId,form);
        return AdministrateurDto.of(administrateur);

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }
}
