package swintegration.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swintegration.emp.model.Employee;
import swintegration.emp.repository.EmployeeRepository;

/**
 * This is Service class that performs Employee CRUD operations.
 * 
 * @author Durga
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	/**
	 * This method fetches all the employee records.
	 * 
	 * @return
	 */
	public List<Employee> findAll() {
		return empRepository.findAll();
	}

	/**
	 * This method fetches employee by id.
	 * 
	 * @param id
	 * @return
	 */
	public Employee findById(Long id) {
		Optional<Employee> employee = empRepository.findById(id);
		return employee.isPresent() ? employee.get() : null;
	}

	/**
	 * This method creates new employee record.
	 * 
	 * @param employee
	 * @return
	 */
	public Employee save(Employee employee) {
		return empRepository.saveAndFlush(employee);
	}

	/**
	 * This method deletes the employee by id.
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		empRepository.deleteById(id);
	}

	/**
	 * This method updates the employee by id.
	 * 
	 * @param employee
	 * @return
	 */
	public Employee update(Employee employee) {
		return empRepository.saveAndFlush(employee);
	}
}
