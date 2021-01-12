package swintegration.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import swintegration.emp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
