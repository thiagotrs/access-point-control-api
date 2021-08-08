package one.digitalinnovation.accesspoint.dto.mapper;

import org.mapstruct.Mapper;

import one.digitalinnovation.accesspoint.dto.request.AccessLevelDTO;
import one.digitalinnovation.accesspoint.entities.AccessLevel;

@Mapper(componentModel = "spring")
public interface AccessLevelMapper {
    
    AccessLevel toModel(AccessLevelDTO dto);

    AccessLevelDTO toDTO(AccessLevel accessLevel);
}
