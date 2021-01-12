package swintegration.emp.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swintegration.emp.model.Employee;
import swintegration.emp.service.EmployeeService;
/**
 * This controller class provides CRUD operations on the employee.
 * @author Durga
 *
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * This method fetches all the employee records.
	 * @return
	 */
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Employee>> findAll() {
		return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
	}

	/**
	 * This method creates new employee record.
	 * @param employee
	 * @return
	 */
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);

	}

	/**
	 * This method fetches employee by id.
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
	}

	/**
	 * This method deletes the employee by id.
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			employeeService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * This method updates the employee by id.
	 * @param id
	 * @param updatedEmployee
	 * @return
	 */
	@PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody Employee updatedEmployee) {
		Employee employee = employeeService.findById(id);
		if (Objects.nonNull(employee)) {
			BeanUtils.copyProperties(updatedEmployee, employee);
			employee.setId(id);
			return new ResponseEntity<>(employeeService.update(employee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updatedEmployee, HttpStatus.NOT_FOUND);
		}
	}
}
