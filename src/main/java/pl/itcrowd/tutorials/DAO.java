package pl.itcrowd.tutorials;

import pl.itcrowd.tutorials.elementCollection.Ensemble;
import pl.itcrowd.tutorials.relations.ManyToMany.Course;

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

    public List<Course> getListOfCourses() {
        return entityManager.createQuery("select distinct c from Course c inner join c.students s")
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void generateEnsemble() {
        final Ensemble ensemble = new Ensemble("en1");

        ensemble.getSongs().add("song1");
        ensemble.getSongs().add("song2");
        ensemble.getSongs().add("song3");

        entityManager.persist(ensemble);
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
}
