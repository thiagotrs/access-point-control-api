package one.digitalinnovation.accesspoint.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinnovation.accesspoint.dto.mapper.EmployeeMapper;
import one.digitalinnovation.accesspoint.dto.request.EmployeeDTO;
import one.digitalinnovation.accesspoint.entities.Employee;
import one.digitalinnovation.accesspoint.exceptions.EmployeeNotFoundException;
import one.digitalinnovation.accesspoint.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    
    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> listAll() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(employeeMapper::toDTO).collect(Collectors.toList());
    }

    public EmployeeDTO findById(Long id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return employeeMapper.toDTO(employee);
    }

    public void delete(Long id) throws EmployeeNotFoundException {
        employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.deleteById(id);
    }

    public void create(EmployeeDTO dto) {      
        Employee employee = employeeMapper.toModel(dto);
        employeeRepository.save(employee);
    }
}
