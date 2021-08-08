package one.digitalinnovation.accesspoint.dto.mapper;

import org.mapstruct.Mapper;

import one.digitalinnovation.accesspoint.dto.request.EmployeeDTO;
import one.digitalinnovation.accesspoint.entities.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    
    Employee toModel(EmployeeDTO dto);

    EmployeeDTO toDTO(Employee employee);
}
