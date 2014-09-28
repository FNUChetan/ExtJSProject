package controller;

import java.util.List;

import model.Question;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class MyController
{
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_QUESTIONS, method = RequestMethod.GET)
	public @ResponseBody
	List<Question> getAllQuestions()
	{
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		QuestionDao questionDao = (QuestionDao) beanFactory.getBean("quesDao");
		DetachedCriteria criteria1 = DetachedCriteria.forClass(Question.class);
		List<Question> quesList1 = questionDao.getQuestionByCriteria(criteria1);
		
		return quesList1;
	}
}
