package controller;

//import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
//import org.apache.commons.dbcp.BasicDataSource;
import java.util.List;
import model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeDao
{
    HibernateTemplate hibernateTemplate;
    
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    public List<Employee> getEmployeeByCriteria(DetachedCriteria c)
    {
        System.out.println("Line 0");
        List<Employee> empList = hibernateTemplate.findByCriteria(c);
        System.out.println("Line -1");
        return empList;
    }
}
