package pl.itcrowd.tutorials;

import pl.itcrowd.tutorials.elementCollection.Ensemble;
import pl.itcrowd.tutorials.relations.ManyToMany.Course;
import pl.itcrowd.tutorials.relations.ManyToMany.EmbeddedAddress;
import pl.itcrowd.tutorials.relations.ManyToMany.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/21/13
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class DAO {
    private static final Logger LOGGER = Logger.getLogger(DAO.class.getCanonicalName());


    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceUnit
    EntityManagerFactory emf;

    @EJB
    private Lazy lazy;


    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void generateEnsemble() {
        final Ensemble ensemble = new Ensemble("en1");

        ensemble.getSongs().add("song1");
        ensemble.getSongs().add("song2");
        ensemble.getSongs().add("song3");

        entityManager.persist(ensemble);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void evictCache() {
        Cache cache = emf.getCache();
        cache.evict(Ensemble.class);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void checkCache() {
        Cache cache = emf.getCache();
        if (cache.contains(Ensemble.class, 1L))
            LOGGER.info("CACHE");
        else
            LOGGER.info("NOT CACHE");
    }

    public void showEnsemble() {
        Ensemble ensemble = entityManager.find(Ensemble.class, 1L);
        LOGGER.info("Ensemble=" + ensemble.getName());

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void generateManyToMany() {
        final Student student1 = new Student("st1");
        final Student student2 = new Student("st2");
        final Student student3 = new Student("st3");

        EmbeddedAddress address = new EmbeddedAddress("street", "city", "11111");

        final Course course1 = new Course("eng");
        final Course course2 = new Course("deu");
        final Course course3 = new Course("fra");

        course1.setAddress(address);
        course2.setAddress(address);
        course3.setAddress(address);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        course2.getStudents().add(student2);
        course2.getStudents().add(student3);
        course3.getStudents().add(student3);


        entityManager.persist(course1);
        entityManager.persist(course2);
        entityManager.persist(course3);


    }

    public void query() {

        List<Course> list = lazy.getListOfCourses();


        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getStudents().size(); j++)
                LOGGER.info(list.get(i).getName() + " " + list.get(i).getStudents().get(j).getName());
        }

    }
}
