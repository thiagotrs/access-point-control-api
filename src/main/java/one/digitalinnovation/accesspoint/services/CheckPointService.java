package one.digitalinnovation.accesspoint.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinnovation.accesspoint.dto.mapper.CheckPointMapper;
import one.digitalinnovation.accesspoint.dto.request.CheckPointDTO;
import one.digitalinnovation.accesspoint.entities.CheckPoint;
import one.digitalinnovation.accesspoint.exceptions.CheckPointNotFoundException;
import one.digitalinnovation.accesspoint.repositories.CheckPointRepository;

@Service
public class CheckPointService {
    
    private CheckPointRepository checkPointRepository;
    private CheckPointMapper checkPointMapper;

    public CheckPointService(CheckPointRepository checkPointRepository, CheckPointMapper checkPointMapper) {
        this.checkPointRepository = checkPointRepository;
        this.checkPointMapper = checkPointMapper;
    }

    public List<CheckPointDTO> listAll() {
        List<CheckPoint> checkPoints = checkPointRepository.findAll();

        return checkPoints.stream().map(checkPointMapper::toDTO).collect(Collectors.toList());
    }

    public CheckPointDTO findById(Long id) throws CheckPointNotFoundException {
        CheckPoint checkPoint = checkPointRepository.findById(id).orElseThrow(() -> new CheckPointNotFoundException(id));
        return checkPointMapper.toDTO(checkPoint);
    }

    public void delete(Long id) throws CheckPointNotFoundException {
        checkPointRepository.findById(id).orElseThrow(() -> new CheckPointNotFoundException(id));
        checkPointRepository.deleteById(id);
    }

    public void create(CheckPointDTO dto) {      
        CheckPoint checkPoint = checkPointMapper.toModel(dto);
        checkPointRepository.save(checkPoint);
    }
}
