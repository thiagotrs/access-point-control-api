package one.digitalinnovation.accesspoint.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CheckPointNotFoundException extends Exception {
    
    public CheckPointNotFoundException(Long id) {
        super(String.format("Check Point with ID %s not found!", id));
    }
}
