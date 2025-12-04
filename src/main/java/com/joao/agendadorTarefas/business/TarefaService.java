package com.joao.agendadorTarefas.business;

import com.joao.agendadorTarefas.business.dto.TarefasDTO;
import com.joao.agendadorTarefas.business.mapper.TarefaConverter;
import com.joao.agendadorTarefas.infraestructure.entity.TarefasEntity;
import com.joao.agendadorTarefas.infraestructure.enums.StatusNoficacaoEnum;
import com.joao.agendadorTarefas.infraestructure.repository.TarefasRepository;
import com.joao.agendadorTarefas.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;


    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNoficacaoEnum(StatusNoficacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);


        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
}
