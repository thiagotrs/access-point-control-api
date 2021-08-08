package one.digitalinnovation.accesspoint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.accesspoint.entities.AccessEntry;

public interface AccessEntryRepository extends JpaRepository<AccessEntry, Long> {
    
}
