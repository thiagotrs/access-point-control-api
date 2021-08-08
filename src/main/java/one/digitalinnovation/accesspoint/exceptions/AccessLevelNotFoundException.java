package one.digitalinnovation.accesspoint.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccessLevelNotFoundException extends Exception {
    public AccessLevelNotFoundException(Long id) {
        super(String.format("Access Level with ID %s not found!", id));
    }
}
