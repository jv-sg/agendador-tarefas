package com.joao.agendadorTarefas.business.mapper;

import com.joao.agendadorTarefas.business.dto.TarefasDTO;
import com.joao.agendadorTarefas.infraestructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

}
