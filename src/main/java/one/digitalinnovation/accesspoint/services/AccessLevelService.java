package one.digitalinnovation.accesspoint.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinnovation.accesspoint.dto.mapper.AccessLevelMapper;
import one.digitalinnovation.accesspoint.dto.request.AccessLevelDTO;
import one.digitalinnovation.accesspoint.entities.AccessLevel;
import one.digitalinnovation.accesspoint.exceptions.AccessLevelNotFoundException;
import one.digitalinnovation.accesspoint.repositories.AccessLevelRepository;

@Service
public class AccessLevelService {
    
    private AccessLevelRepository accessLevelRepository;
    private AccessLevelMapper accessLevelMapper;

    public AccessLevelService(AccessLevelRepository accessLevelRepository, AccessLevelMapper accessLevelMapper) {
        this.accessLevelRepository = accessLevelRepository;
        this.accessLevelMapper = accessLevelMapper;
    }

    public List<AccessLevelDTO> listAll() {
        List<AccessLevel> accessLevels = accessLevelRepository.findAll();
        return accessLevels.stream().map(accessLevelMapper::toDTO).collect(Collectors.toList());
    }

    public AccessLevelDTO findById(Long id) throws AccessLevelNotFoundException {
        AccessLevel accessLevel = accessLevelRepository.findById(id).orElseThrow(() -> new AccessLevelNotFoundException(id));
        return accessLevelMapper.toDTO(accessLevel);
    }

    public void delete(Long id) throws AccessLevelNotFoundException {
        accessLevelRepository.findById(id).orElseThrow(() -> new AccessLevelNotFoundException(id));
        accessLevelRepository.deleteById(id);
    }

    public void create(AccessLevelDTO dto) {      
        AccessLevel accessLevel = accessLevelMapper.toModel(dto);
        accessLevelRepository.save(accessLevel);
    }
}
