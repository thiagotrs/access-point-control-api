package one.digitalinnovation.accesspoint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.accesspoint.entities.WorkRegime;

public interface WorkRegimeRepository extends JpaRepository<WorkRegime, Long> {
    
}
