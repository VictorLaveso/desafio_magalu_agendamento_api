package com.magalu.desafio.core.repositories;

import com.magalu.desafio.core.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
