package one.digitalinnovation.accesspoint.dto.mapper;

import org.mapstruct.Mapper;

import one.digitalinnovation.accesspoint.dto.request.AccessEntryDTO;
import one.digitalinnovation.accesspoint.entities.AccessEntry;

@Mapper(componentModel = "spring")
public interface AccessEntryMapper {
    
    AccessEntry toModel(AccessEntryDTO dto);

    
    AccessEntryDTO toDTO(AccessEntry accessEntry);
}
