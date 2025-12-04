package com.joao.agendadorTarefas.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joao.agendadorTarefas.infraestructure.enums.StatusNoficacaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTO {

    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNoficacaoEnum statusNoficacaoEnum;

}
