package com.magalu.desafio.controller.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.magalu.desafio.core.enums.StatusNotificacaoEnum;

import java.time.LocalDateTime;

public record AgendamentoRecordOut(Long id,
                                   String emailDestinatario,
                                   String telefoneDestinatario,
                                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                   LocalDateTime dataHoraEnvio,
                                   String mensagem,
                                   StatusNotificacaoEnum statusNotificacaoEnum) {
}
