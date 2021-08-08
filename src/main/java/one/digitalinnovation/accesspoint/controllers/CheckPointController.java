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

import one.digitalinnovation.accesspoint.dto.request.CheckPointDTO;
import one.digitalinnovation.accesspoint.exceptions.CheckPointNotFoundException;
import one.digitalinnovation.accesspoint.services.CheckPointService;

@RestController
@RequestMapping("/api/v1/check-point")
public class CheckPointController {
    
    private CheckPointService checkPointService;

    public CheckPointController(CheckPointService checkPointService) {
        this.checkPointService = checkPointService;
    }

    @GetMapping
    public List<CheckPointDTO> listAll() {
        return checkPointService.listAll();
    }

    @GetMapping("/{id}")
    public CheckPointDTO findById(@PathVariable Long id) throws CheckPointNotFoundException {
        return checkPointService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws CheckPointNotFoundException {
        checkPointService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CheckPointDTO dto) {
        checkPointService.create(dto);
    }
}
