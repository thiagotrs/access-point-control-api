package one.digitalinnovation.accesspoint.dto.request;

import java.time.LocalTime;

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
public class WorkRegimeDTO {
    
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    private LocalTime initWorkDay;

    private LocalTime finalWorkDay;

    private LocalTime toleranceTime;
}
