package one.digitalinnovation.accesspoint.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WorkRegimeNotFoundException extends Exception {
    
    public WorkRegimeNotFoundException(Long id) {
        super(String.format("Work Regime with ID %s not found!", id));
    }
}
