package one.digitalinnovation.accesspoint.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinnovation.accesspoint.dto.mapper.WorkRegimeMapper;
import one.digitalinnovation.accesspoint.dto.request.WorkRegimeDTO;
import one.digitalinnovation.accesspoint.entities.WorkRegime;
import one.digitalinnovation.accesspoint.exceptions.WorkRegimeNotFoundException;
import one.digitalinnovation.accesspoint.repositories.WorkRegimeRepository;

@Service
public class WorkRegimeService {
    
    private WorkRegimeRepository workRegimeRepository;
    private WorkRegimeMapper workRegimeMapper;

    public WorkRegimeService(WorkRegimeRepository workRegimeRepository, WorkRegimeMapper workRegimeMapper) {
        this.workRegimeRepository = workRegimeRepository;
        this.workRegimeMapper = workRegimeMapper;
    }

    public List<WorkRegimeDTO> listAll() {
        List<WorkRegime> workRegimes = workRegimeRepository.findAll();
        return workRegimes.stream().map(workRegimeMapper::toDTO).collect(Collectors.toList());
    }

    public WorkRegimeDTO findById(Long id) throws WorkRegimeNotFoundException {
        WorkRegime workRegime = workRegimeRepository.findById(id).orElseThrow(() -> new WorkRegimeNotFoundException(id));
        return workRegimeMapper.toDTO(workRegime);
    }

    public void delete(Long id) throws WorkRegimeNotFoundException {
        workRegimeRepository.findById(id).orElseThrow(() -> new WorkRegimeNotFoundException(id));
        workRegimeRepository.deleteById(id);
    }

    public void create(WorkRegimeDTO dto) {      
        WorkRegime WorkRegime = workRegimeMapper.toModel(dto);
        workRegimeRepository.save(WorkRegime);
    }
}
