package one.digitalinnovation.accesspoint.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinnovation.accesspoint.dto.mapper.AccessEntryMapper;
import one.digitalinnovation.accesspoint.dto.request.AccessEntryDTO;
import one.digitalinnovation.accesspoint.entities.AccessEntry;
import one.digitalinnovation.accesspoint.exceptions.AccessEntryNotFoundException;
import one.digitalinnovation.accesspoint.exceptions.CheckPointNotFoundException;
import one.digitalinnovation.accesspoint.exceptions.EmployeeNotFoundException;
import one.digitalinnovation.accesspoint.repositories.AccessEntryRepository;
import one.digitalinnovation.accesspoint.repositories.CheckPointRepository;
import one.digitalinnovation.accesspoint.repositories.EmployeeRepository;

@Service
public class AccessEntryService {
    
    private AccessEntryRepository accessEntryRepository;
    private EmployeeRepository employeeRepository;
    private CheckPointRepository checkPointRepository;

    private AccessEntryMapper accessEntryMapper;

    public AccessEntryService(
        AccessEntryRepository accessEntryRepository, 
        AccessEntryMapper accessEntryMapper,
        EmployeeRepository employeeRepository,
        CheckPointRepository checkPointRepository
    ) {
        this.accessEntryRepository = accessEntryRepository;
        this.accessEntryMapper = accessEntryMapper;
        this.employeeRepository = employeeRepository;
        this.checkPointRepository = checkPointRepository;
    }
    
    public List<AccessEntryDTO> listAll() {
        List<AccessEntry> accessEntrys = accessEntryRepository.findAll();

        return accessEntrys.stream().map(accessEntryMapper::toDTO).collect(Collectors.toList());
    }

    public AccessEntryDTO findById(Long id) throws AccessEntryNotFoundException {
        AccessEntry accessEntry = accessEntryRepository.findById(id).orElseThrow(() -> new AccessEntryNotFoundException(id));
        return accessEntryMapper.toDTO(accessEntry);
    }

    public void delete(Long id) throws AccessEntryNotFoundException {
        accessEntryRepository.findById(id).orElseThrow(() -> new AccessEntryNotFoundException(id));
        accessEntryRepository.deleteById(id);
    }

    public void create(AccessEntryDTO dto) throws EmployeeNotFoundException, CheckPointNotFoundException {   
        employeeRepository.findById(dto.getEmployeeId()).orElseThrow(() -> new EmployeeNotFoundException(dto.getEmployeeId()));
        checkPointRepository.findById(dto.getCheckPointId()).orElseThrow(() -> new CheckPointNotFoundException(dto.getCheckPointId()));

        AccessEntry accessEntry = accessEntryMapper.toModel(dto);
        accessEntryRepository.save(accessEntry);
    }

    public void update(Long id, AccessEntryDTO dto) 
        throws AccessEntryNotFoundException, EmployeeNotFoundException, CheckPointNotFoundException {

        accessEntryRepository.findById(id).orElseThrow(() -> new AccessEntryNotFoundException(id));
        employeeRepository.findById(dto.getEmployeeId()).orElseThrow(() -> new EmployeeNotFoundException(dto.getEmployeeId()));
        checkPointRepository.findById(dto.getCheckPointId()).orElseThrow(() -> new CheckPointNotFoundException(dto.getCheckPointId()));
        
        AccessEntry updatedAccessEntry = accessEntryMapper.toModel(dto);
        accessEntryRepository.save(updatedAccessEntry);
    }
}
