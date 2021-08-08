
package one.digitalinnovation.accesspoint.dto.mapper;

import org.mapstruct.Mapper;

import one.digitalinnovation.accesspoint.dto.request.WorkRegimeDTO;
import one.digitalinnovation.accesspoint.entities.WorkRegime;

@Mapper(componentModel = "spring")
public interface WorkRegimeMapper {

    WorkRegime toModel(WorkRegimeDTO dto);

    WorkRegimeDTO toDTO(WorkRegime workRegime);
}