package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.slf4j.Logger;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Employee;
import model.Question;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class MyController {
	
	//private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
        
        @RequestMapping(value = EmpRestURIConstants.GET_ALL_QUESTIONS, method = RequestMethod.GET)
	public @ResponseBody List<Question> getAllQuestions() {
		//logger.info("Start getAllEmployees.");
                System.out.println("Line 1");
                Resource resource = new ClassPathResource("applicationContext.xml");
                System.out.println("Line 2");
                BeanFactory beanFactory = new XmlBeanFactory(resource);
                System.out.println("Line 3");
                
                QuestionDao questionDao = (QuestionDao)beanFactory.getBean("quesDao");
                System.out.println("Line 4");
            
		DetachedCriteria criteria1 = DetachedCriteria.forClass(Question.class);
                System.out.println("Line 5");
                List<Question> quesList1 = questionDao.getQuestionByCriteria(criteria1);
                System.out.println("Line 6");
                
		return quesList1;
	}
	
	@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee() {
		//logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setRegistered(new Date());
		empData.put(9999, emp);
		return emp;
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		//logger.info("Start getEmployee. ID="+empId);
		
		Employee e1=new Employee();
		//retrieve employee from database using empId
		e1.setId(empId);		
		e1.setName("Anup");
		e1.setRegistered(new Date());
		
		return e1;
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		//logger.info("Start getAllEmployees.");
                Resource resource = new ClassPathResource("applicationContext.xml");
                BeanFactory beanFactory = new XmlBeanFactory(resource);
                
                EmployeeDao employeeDao = (EmployeeDao)beanFactory.getBean("empDao");
            
		DetachedCriteria criteria1 = DetachedCriteria.forClass(Employee.class);
                List<Employee> empList1 = employeeDao.getEmployeeByCriteria(criteria1);
		
                /*
		Employee emp1 = new Employee();
		emp1.setId(1000);
		emp1.setName("Anup");
		emp1.setAge(35);
		emp1.setGender("Male");
		emp1.setCompany("Hawkster");
		emp1.setEmail("ballbenson@hawkster.com");
		emp1.setPhone("+1 (818) 409-2839");
		emp1.setAddress("Newyork");
		emp1.setGuid("Aliqua sit sit aliquip");
		emp1.setBalance(2100.50f);
		emp1.setAbout("Very interesting person");
		emp1.setRegistered(new Date());
		
		Employee emp2 = new Employee();
		emp2.setId(1001);
		emp2.setName("Vikash");
		emp2.setAge(37);
		emp2.setGender("Male");
		emp2.setCompany("Hawkster");
		emp2.setEmail("ballvikash@hawkster.com");
		emp2.setPhone("+1 (818) 409-2839");
		emp2.setAddress("Newyork");
		emp2.setGuid("Aliqua sit sit aliquip");
		emp2.setBalance(2100.70f);
		emp2.setAbout("Very interesting person");
		emp2.setRegistered(new Date());
		
		Employee emp3 = new Employee();
		emp3.setId(1002);
		emp3.setName("Anjelina");
		emp3.setAge(40);
		emp3.setGender("Female");
		emp3.setCompany("Hawkster");
		emp3.setEmail("ballanj@hawkster.com");
		emp3.setPhone("+1 (818) 409-2839");
		emp3.setAddress("Newyork");
		emp3.setGuid("Aliqua sit sit aliquip");
		emp3.setBalance(2200.50f);
		emp3.setAbout("Very interesting person");
		emp3.setRegistered(new Date());
		
		Employee emp4 = new Employee();
		emp4.setId(1003);
		emp4.setName("Armaan");
		emp4.setAge(24);
		emp4.setGender("Male");
		emp4.setCompany("Hawkster");
		emp4.setEmail("ballarmaan@hawkster.com");
		emp4.setPhone("+1 (818) 409-2839");
		emp4.setAddress("Newyork");
		emp4.setGuid("Aliqua sit sit aliquip");
		emp4.setBalance(2110.50f);
		emp4.setAbout("Very interesting person");
		emp4.setRegistered(new Date());
		
		empData.put(1111, emp1);
		empData.put(2222, emp2);
		empData.put(3333, emp3);
		empData.put(4444, emp4);
		
		Set<Integer> empIdKeys = empData.keySet();
		for(Integer i : empIdKeys){
			empList1.add(empData.get(i));
		}
                */
                
		return empList1;
	}
	
	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		//logger.info("Start createEmployee.");
		emp.setRegistered(new Date());
		empData.put(emp.getId(), emp);
		return emp;
	}
	
	@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		//logger.info("Start deleteEmployee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
	
}