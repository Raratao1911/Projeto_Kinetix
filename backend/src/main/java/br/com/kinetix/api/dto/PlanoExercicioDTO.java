package br.com.kinetix.api.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
public class PlanoExercicioDTO {
    @NotNull(message = "O exercicio e obrigatorio.")
    private Long exercicioId;
    @Positive(message = "As series devem ser maiores que zero.")
    private Integer series;
    @Positive(message = "As repeticoes devem ser maiores que zero.")
    private Integer repeticoes;
    @Positive(message = "O tempo de execucao deve ser maior que zero.")
    private Integer tempoExecucao;
}
