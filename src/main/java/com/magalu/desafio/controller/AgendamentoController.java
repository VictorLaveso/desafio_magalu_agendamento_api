package com.magalu.desafio.controller;

import com.magalu.desafio.business.AgendamentoService;
import com.magalu.desafio.controller.dto.in.AgendamentoRecord;
import com.magalu.desafio.controller.dto.out.AgendamentoRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoRecordOut> gravarAgendamentos(@RequestBody AgendamentoRecord agendamento) {
        return ResponseEntity.ok(agendamentoService.gravarAgendamento(agendamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoRecordOut> buscarAgendamentoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(agendamentoService.buscarAgendamentoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable("id") Long id) {
        agendamentoService.cancelarAgendamento(id);
        return ResponseEntity.accepted().build();
    }

}
