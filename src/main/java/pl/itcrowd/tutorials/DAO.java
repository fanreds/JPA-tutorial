package pl.itcrowd.tutorials;

import pl.itcrowd.tutorials.relations.ManyToMany.Course;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/21/13
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class DAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Course> getListOfCourses(){
        return entityManager.createQuery("select distinct c from Course c inner join c.students s")
                .getResultList();
    }
}
