package com.magalu.desafio.business.mapper;

import com.magalu.desafio.controller.dto.in.AgendamentoRecord;
import com.magalu.desafio.controller.dto.out.AgendamentoRecordOut;
import com.magalu.desafio.core.entities.Agendamento;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
@org.springframework.stereotype.Component("agendamentoMapper")
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecord agendamento);

    AgendamentoRecordOut paraout(Agendamento agendamento);
}
