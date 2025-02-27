package com.magalu.desafio.business;


import com.magalu.desafio.business.mapper.IAgendamentoMapper;
import com.magalu.desafio.controller.dto.in.AgendamentoRecord;
import com.magalu.desafio.controller.dto.out.AgendamentoRecordOut;
import com.magalu.desafio.core.NotFoundException;
import com.magalu.desafio.core.entities.Agendamento;
import com.magalu.desafio.core.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;
    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento) {
        return agendamentoMapper.paraout(
                repository.save(
                        agendamentoMapper.paraEntity(agendamento)));
    }

    public AgendamentoRecordOut buscarAgendamentoPorId(Long id) {
        return agendamentoMapper.paraout(repository.findById(id).orElseThrow(() -> new NotFoundException("Id não encontrado")));
    }

    public void cancelarAgendamento(Long id) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado"));
        repository.save(
                agendamentoMapper.paraEntityCancelamento(agendamento));
    }
}
