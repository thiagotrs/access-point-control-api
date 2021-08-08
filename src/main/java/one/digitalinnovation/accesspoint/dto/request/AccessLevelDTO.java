package one.digitalinnovation.accesspoint.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccessLevelDTO {
    
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;
}
