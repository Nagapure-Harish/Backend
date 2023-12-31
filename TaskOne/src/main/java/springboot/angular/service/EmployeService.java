package springboot.angular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.angular.Repository.EmployeeRepository;
import springboot.angular.model.Employee;
import springboot.angular.pojo.Pojo;
@Service
public class EmployeService {
    @Autowired
	private EmployeeRepository employeeRepository;
     
    public String create(Pojo pojo) {
    	Employee e = new Employee();   
    	e.setAddress(pojo.getAddress());
//    	e.setPassword(new BCryptPasswordEncoder().encode(pojo.getPassword()));
    	e.setBp(pojo.getBp());
    	e.setDepartment(pojo.getDepartment());
    	e.setEmail_id(pojo.getEmail_id());
    	e.setEmp_id(pojo.getEmp_id());
    	e.setEmp_type(pojo.getEmp_type());
    	e.setMobile_no(pojo.getMobile_no());
    	e.setOrg_name(pojo.getOrg_name());
    	e.setRole(pojo.getRole());
    	 employeeRepository.save(e);
    	 return "Success";
    }
    	 
    	public  Optional<Employee> getEmployee(long Emp_id){
  		 return employeeRepository.findById(Emp_id);
     }    	

      public List<Employee> getAll() {
    	  return employeeRepository.findAll();
      }
      
      public Employee updateSer(Employee employee) {
    	   Optional<Employee> optional =  employeeRepository.findById(employee.getEmp_id());
    	   
    	   if(optional!=null) {
    		   employeeRepository.save(employee);
    	   }
    	   return optional.get();
      }
      
      public void deleteEmployeeById(Long Emp_id) {
          employeeRepository.deleteById(Emp_id);
      }

}
