package springboot.angular.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.angular.model.Employee;
import springboot.angular.pojo.Pojo;
import springboot.angular.service.EmployeService;
@CrossOrigin(value ="http://localhost:4200/" )
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
  
	@Autowired 
	private EmployeService employeeservice;
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return employeeservice.getAll();
	}
	
	@PostMapping("/post")
	public String createEmployee(@RequestBody Pojo employee) { 
		return employeeservice.create(employee);
	}
	
//	@GetMapping("/get/{Emp_id}")
//	public Optional<Employee> getEmployeeById(@PathVariable long Emp_id) {
//		return employeeservice.getEmployee(Emp_id);
//	}
	
	@PutMapping("/put")
	public Employee update(@RequestBody Employee employee){
		return employeeservice.updateSer(employee);
	}
	
//	@DeleteMapping("/emp4/{id}")
//	public ResponseEntity<Map<String, Boolean>>deleteEmployee(@PathVariable Long id){
//		Employee employee = employeeRepository.findById(id).orElseThrow(()->
//		new ResourceNotFoundException("employee not exist with id :"+id));
//		
//		employeeRepository.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
	
	 @DeleteMapping("/Delete/{id}")
	    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
	        Optional<Employee> employee = employeeservice.getEmployee(id);

	        if (employee.isPresent()) {
	            employeeservice.deleteEmployeeById(id);
	            return new ResponseEntity<>("Employee with ID " +id + " deleted successfully.", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Employee with ID " + id + " not found.", HttpStatus.NOT_FOUND);
	        }
	    }

}
