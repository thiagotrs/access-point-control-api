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

import one.digitalinnovation.accesspoint.dto.request.WorkRegimeDTO;
import one.digitalinnovation.accesspoint.exceptions.WorkRegimeNotFoundException;
import one.digitalinnovation.accesspoint.services.WorkRegimeService;

@RestController
@RequestMapping("/api/v1/work-regime")
public class WorkRegimeController {
    
    private WorkRegimeService workRegimeService;

    public WorkRegimeController( WorkRegimeService workRegimeService) {
        this.workRegimeService = workRegimeService;
    }

    @GetMapping
    public List<WorkRegimeDTO> listAll() {
        return workRegimeService.listAll();
    }

    @GetMapping("/{id}")
    public WorkRegimeDTO findById(@PathVariable Long id) throws WorkRegimeNotFoundException {
        return workRegimeService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws WorkRegimeNotFoundException {
        workRegimeService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid WorkRegimeDTO dto) {
        workRegimeService.create(dto);
    }
}
