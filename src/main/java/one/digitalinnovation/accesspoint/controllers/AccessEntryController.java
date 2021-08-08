package one.digitalinnovation.accesspoint.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.accesspoint.dto.request.AccessEntryDTO;
import one.digitalinnovation.accesspoint.exceptions.AccessEntryNotFoundException;
import one.digitalinnovation.accesspoint.exceptions.CheckPointNotFoundException;
import one.digitalinnovation.accesspoint.exceptions.EmployeeNotFoundException;
import one.digitalinnovation.accesspoint.services.AccessEntryService;

@RestController
@RequestMapping("/api/v1/access-entry")
public class AccessEntryController {
    
    private AccessEntryService accessEntryService;

    public AccessEntryController(AccessEntryService accessEntryService) {
        this.accessEntryService = accessEntryService;
    }

    @GetMapping
    public List<AccessEntryDTO> listAll() {
        return accessEntryService.listAll();
    }

    @GetMapping("/{id}")
    public AccessEntryDTO findById(@PathVariable Long id) throws AccessEntryNotFoundException {
        return accessEntryService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws AccessEntryNotFoundException {
        accessEntryService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid AccessEntryDTO dto) 
        throws EmployeeNotFoundException, CheckPointNotFoundException {
            
        accessEntryService.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid AccessEntryDTO dto) 
        throws AccessEntryNotFoundException, EmployeeNotFoundException, CheckPointNotFoundException {
        
        accessEntryService.update(id, dto);
    }
}
