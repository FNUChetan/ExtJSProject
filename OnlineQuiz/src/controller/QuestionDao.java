package controller;

import java.util.List;
import model.Question;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class QuestionDao
{
    HibernateTemplate hibernateTemplate;
    
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    public List<Question> getQuestionByCriteria(DetachedCriteria c)
    {
        System.out.println("Line 0");
        List<Question> quesList = hibernateTemplate.findByCriteria(c);
        System.out.println("Line -1");
        return quesList;
    }
}
