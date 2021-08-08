package one.digitalinnovation.accesspoint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.accesspoint.entities.CheckPoint;

public interface CheckPointRepository extends JpaRepository<CheckPoint, Long> {
    
}
