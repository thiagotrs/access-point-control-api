package one.digitalinnovation.accesspoint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.accesspoint.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
