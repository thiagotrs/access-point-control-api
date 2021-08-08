package one.digitalinnovation.accesspoint.dto.mapper;

import org.mapstruct.Mapper;

import one.digitalinnovation.accesspoint.dto.request.CheckPointDTO;
import one.digitalinnovation.accesspoint.entities.CheckPoint;

@Mapper(componentModel = "spring")
public interface CheckPointMapper {
    
    CheckPoint toModel(CheckPointDTO dto);

    CheckPointDTO toDTO(CheckPoint checkPoint);
}
