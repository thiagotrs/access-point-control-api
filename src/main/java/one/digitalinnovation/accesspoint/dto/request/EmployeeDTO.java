package one.digitalinnovation.accesspoint.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.accesspoint.entities.AccessLevel;
import one.digitalinnovation.accesspoint.entities.WorkRegime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String fullName;

    @Valid
    @NotNull
    private WorkRegime workRegime;

    @Valid
    @NotNull
    private AccessLevel accessLevel;
}
