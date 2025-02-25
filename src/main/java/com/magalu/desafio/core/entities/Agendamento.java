package com.magalu.desafio.core.entities;


import com.magalu.desafio.core.enums.StatusNotificacaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "agendamento")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String emailDestinatario;
    private String telefoneDestinatario;
    private LocalDateTime dataHoraEnvio;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataHoraModificacao;
    private String mensagem;
    private StatusNotificacaoEnum statusNotificacaoEnum;

    @PrePersist
    public void prePersist(){
        dataHoraAgendamento = LocalDateTime.now();
        statusNotificacaoEnum = StatusNotificacaoEnum.AGENDADO;
    }

}
