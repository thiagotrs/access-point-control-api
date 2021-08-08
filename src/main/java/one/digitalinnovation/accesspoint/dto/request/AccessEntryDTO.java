package one.digitalinnovation.accesspoint.dto.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccessEntryDTO {
    
    private Long id;

    @NotNull
    private Long employeeId;

    @PastOrPresent
    private LocalDateTime entrance;

    @PastOrPresent
    private LocalDateTime exit;

    @NotNull
    private Long checkPointId;
}
