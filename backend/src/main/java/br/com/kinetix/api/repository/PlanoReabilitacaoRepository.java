package br.com.kinetix.api.repository;

import br.com.kinetix.api.domain.PlanoReabilitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlanoReabilitacaoRepository extends JpaRepository<PlanoReabilitacao, Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE PlanoReabilitacao p SET p.status = 'FINALIZADO' WHERE p.paciente.id = :pacienteId AND p.status = 'ATIVO'")
    void finalizarPlanosAtivos(@Param("pacienteId") Long pacienteId);

    Optional<PlanoReabilitacao> findFirstByPacienteIdAndStatusOrderByDataCriacaoDesc(Long pacienteId, String status);
}
