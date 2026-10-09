package br.com.kinetix.api.controller;

import br.com.kinetix.api.dto.PlanoReabilitacaoRequestDTO;
import br.com.kinetix.api.service.PlanoReabilitacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PlanoReabilitacaoController {

    private final PlanoReabilitacaoService planoService;

    @PostMapping("/{id}/plano-reabilitacao")
    public ResponseEntity<?> criarPlano(
            @PathVariable Long id, 
            @Valid @RequestBody PlanoReabilitacaoRequestDTO dto) {
        planoService.criarNovoPlano(id, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/plano-atual")
    public ResponseEntity<?> getPlanoAtual(@PathVariable Long id) {
        var plano = planoService.buscarPlanoAtivo(id);
        return ResponseEntity.ok(plano);
    }
}
