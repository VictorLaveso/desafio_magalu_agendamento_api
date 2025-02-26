package com.magalu.desafio.business.mapper;

import com.magalu.desafio.controller.dto.in.AgendamentoRecord;
import com.magalu.desafio.controller.dto.out.AgendamentoRecordOut;
import com.magalu.desafio.core.entities.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.time.LocalDateTime;
import com.magalu.desafio.core.enums.StatusNotificacaoEnum;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
@org.springframework.stereotype.Component("agendamentoMapper")
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecord agendamento);

    AgendamentoRecordOut paraout(Agendamento agendamento);

    @Mapping(target = "dataHoraModificacao", expression = "java(LocalDateTime.now())")
    @Mapping(target = "statusNotificacaoEnum", expression = "java(StatusNotificacaoEnum.CANCELADO)")
    Agendamento paraEntityCancelamento( Agendamento agendamento);
}
