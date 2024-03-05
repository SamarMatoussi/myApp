package com.kpi.bank.services;


import com.kpi.bank.entites.Agent;
import com.kpi.bank.form.AgentForm;

import java.util.List;
import java.util.Map;

public interface AgentService {
    public Agent addAgent(AgentForm form);
    public Agent updateAgent(Long id, AgentForm form);
    public Agent getAgent(Long id);
    public Map<String,Boolean> deleteAgent(Long id);
    public List<Agent> getAgents();
}
