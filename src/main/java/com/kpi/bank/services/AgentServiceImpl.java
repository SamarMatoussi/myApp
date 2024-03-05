package com.kpi.bank.services;

import com.kpi.bank.entites.Agent;
import com.kpi.bank.form.AgentForm;
import com.kpi.bank.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    AgentRepository agentRepository;

    @Override
    public Agent addAgent(AgentForm form) {
        Agent agent = new Agent();
        agent.setNom(form.getLastname());
        agent.setPrenom(form.getFirstname());
        agent.setEmail(form.getEmail());
        agent.setPhone(form.getPhone());
        return agentRepository.save(agent);
    }

    @Override
    public Agent updateAgent(Long id, AgentForm form) {
        Agent agent = getAgent(id);
        agent.setNom(form.getLastname());
        agent.setPrenom(form.getFirstname());
        agent.setEmail(form.getEmail());
        agent.setPhone(form.getPhone());
        return agentRepository.save(agent);
    }

    @Override
    public Agent getAgent(Long id) {
        Optional<Agent> agent = agentRepository.findById(id);
        return agent.get();
    }

    @Override
    public Map<String, Boolean> deleteAgent(Long id) {
        Agent agent = getAgent(id);
        agentRepository.delete(agent);
        Map<String, Boolean> map = new HashMap<>();
        map.put("deleted", Boolean.TRUE);
        return map;
    }

    @Override
    public List<Agent> getAgents() {
        return agentRepository.findAll();
    }
    
}