package com.kpi.bank.controller;

import com.kpi.bank.dto.AgentDto;
import com.kpi.bank.entites.Agent;
import com.kpi.bank.form.AgentForm;
import com.kpi.bank.services.AgentService;
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
@RequestMapping("/api/v1/agent")
@PreAuthorize("hasRole('ADMIN')")
//@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AgentController {
    @Autowired
    AgentService agentService;


    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/agent")
    public AgentDto addAgent(@Valid @RequestBody AgentForm form){
        Agent agent =  agentService.addAgent(form);
        return AgentDto.of(agent);
    }

    @PreAuthorize("hasAuthority('admin:read')")
    @GetMapping("/agents")
    public List<AgentDto> getAll(){
        List<Agent> agents = agentService.getAgents();
        return AgentDto.of(agents);
    }

    @PreAuthorize("hasAuthority('admin:read')")
    @GetMapping("/agent/{id}")
    public AgentDto getAgent(@PathVariable("id") long agentId){
        Agent agent = agentService.getAgent(agentId);
        return AgentDto.of(agent);
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/agent/{id}")
    public Map<String,Boolean> deleteAgent(@PathVariable("id") long agentId){
        return agentService.deleteAgent(agentId);
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/agent/{id}")
    public AgentDto updateAgent(@PathVariable("id") long agentId,@Valid @RequestBody AgentForm form){
        Agent agent = agentService.updateAgent(agentId,form);
        return AgentDto.of(agent);
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
