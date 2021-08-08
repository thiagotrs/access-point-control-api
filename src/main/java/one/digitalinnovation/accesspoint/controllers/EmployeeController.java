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

import one.digitalinnovation.accesspoint.dto.request.EmployeeDTO;
import one.digitalinnovation.accesspoint.exceptions.EmployeeNotFoundException;
import one.digitalinnovation.accesspoint.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> listAll() {
        return employeeService.listAll();
    }

    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws EmployeeNotFoundException {
        employeeService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid EmployeeDTO dto) {
        employeeService.create(dto);
    }
}
