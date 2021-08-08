package one.digitalinnovation.accesspoint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.accesspoint.entities.AccessLevel;

public interface AccessLevelRepository extends JpaRepository<AccessLevel, Long> {
    
}
