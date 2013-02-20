package pl.itcrowd.tutorials;

import pl.itcrowd.tutorials.relations.OneToOne.Address;
import pl.itcrowd.tutorials.relations.OneToOne.Person;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/20/13
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
@Startup
@Singleton
public class MySingleton {
    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void PostConstruct() {
         generateOneToOne();
    }

    public void generateOneToOne(){
        Person person1 = new Person("kowalski");
        Person person2 = new Person("małysz");
        Person person3 = new Person("sobolewski");

        Address address1 = new Address("street1","city1","11111",person1);
        Address address2 = new Address("street2","city2","22222",person2);
        Address address3 = new Address("street3","city3","33333",person3);

        person1.setAddress(address1);
        person2.setAddress(address2);
        person3.setAddress(address3);

        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.persist(address3);

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
    }
}
