package br.com.kinetix.api.dto;

import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Data
public class PlanoReabilitacaoRequestDTO {
    @NotNull(message = "O fisioterapeuta e obrigatorio.")
    private Long fisioterapeutaId;
    @NotEmpty(message = "O plano deve conter ao menos um exercicio.")
    private List<@Valid PlanoExercicioDTO> exercicios;
}
