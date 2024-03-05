package com.kpi.bank.dto;

import com.kpi.bank.entites.Agent;
import com.kpi.bank.form.AgentForm;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AgentDto extends AgentForm {
    private Long id;

    public AgentDto(Agent agent) {
        super(agent);
        this.id = agent.getId();
    }

    public static AgentDto of(Agent agent){

        return new AgentDto(agent);
    }

    public static List<AgentDto> of(List<Agent> agents){
        return agents.stream().map(AgentDto::of).collect(Collectors.toList());
    }
}
