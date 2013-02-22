package pl.itcrowd.tutorials;

import pl.itcrowd.tutorials.relations.ManyToMany.Course;
import pl.itcrowd.tutorials.relations.ManyToMany.Student;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/21/13
 * Time: 8:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class Lazy {
    private static final Logger LOGGER = Logger.getLogger(Lazy.class.getCanonicalName());


    @PersistenceContext
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Course> getListOfCourses() {
        return entityManager.createQuery("select distinct c from Course c inner join c.students s")
                .getResultList();
    }
}
