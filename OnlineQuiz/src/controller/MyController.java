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

	// private static final Logger logger =
	// LoggerFactory.getLogger(EmployeeController.class);

	// Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	@RequestMapping(value = EmpRestURIConstants.GET_ALL_QUESTIONS, method = RequestMethod.GET)
	public @ResponseBody List<Question> getAllQuestions() {
		// logger.info("Start getAllEmployees.");
		System.out.println("Line 1");
		Resource resource = new ClassPathResource("applicationContext.xml");
		System.out.println("Line 2");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		System.out.println("Line 3");

		QuestionDao questionDao = (QuestionDao) beanFactory.getBean("quesDao");
		System.out.println("Line 4");

		DetachedCriteria criteria1 = DetachedCriteria.forClass(Question.class);
		System.out.println("Line 5");
		List<Question> quesList1 = questionDao.getQuestionByCriteria(criteria1);
		System.out.println("Line 6");

		return quesList1;
	}
}