package one.digitalinnovation.accesspoint.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.accesspoint.dto.request.AccessLevelDTO;
import one.digitalinnovation.accesspoint.exceptions.AccessLevelNotFoundException;
import one.digitalinnovation.accesspoint.services.AccessLevelService;

@RestController
@RequestMapping("/api/v1/access-level")
public class AccessLevelController {
    
    private AccessLevelService accessLevelService;

    public AccessLevelController(AccessLevelService accessLevelService) {
        this.accessLevelService = accessLevelService;
    }

    @GetMapping
    public List<AccessLevelDTO> listAll() {
        return accessLevelService.listAll();
    }

    @GetMapping("/{id}")
    public AccessLevelDTO findById(@PathVariable Long id) throws AccessLevelNotFoundException {
        return accessLevelService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws AccessLevelNotFoundException {
        accessLevelService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid AccessLevelDTO dto) {
        accessLevelService.create(dto);
    }
}
