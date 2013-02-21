package pl.itcrowd.tutorials;

import pl.itcrowd.tutorials.relations.ManyToMany.Course;
import pl.itcrowd.tutorials.relations.ManyToMany.EmbeddedAddress;
import pl.itcrowd.tutorials.relations.ManyToMany.Student;
import pl.itcrowd.tutorials.relations.OneToMany.*;
import pl.itcrowd.tutorials.relations.OneToOne.Address;
import pl.itcrowd.tutorials.relations.OneToOne.Person;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

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

    private static final Logger LOGGER = Logger.getLogger(MySingleton.class.getCanonicalName());


    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private DAO dao;

    @PostConstruct
    public void PostConstruct() {
        generateManyToMany();
        query();
    }

    public void generateOneToOne() {
        Person person1 = new Person("kowalski");
        Person person2 = new Person("małysz");
        Person person3 = new Person("sobolewski");

        Address address1 = new Address("street1", "city1", "11111", person1);
        Address address2 = new Address("street2", "city2", "22222", person2);
        Address address3 = new Address("street3", "city3", "33333", person3);

        person1.setAddress(address1);
        person2.setAddress(address2);
        person3.setAddress(address3);

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);

    }

    public void generateOneToMany() {
        final Company companyA = new Company("comp");

        final Department departmentA = new Department("dep1");
        final Department departmentB = new Department("dep2");

        companyA.getDepartments().add(departmentA);
        companyA.getDepartments().add(departmentB);

        departmentA.setCompany(companyA);
        departmentB.setCompany(companyA);

        final Employee employeeA = new Employee(departmentA, "Emp1");
        final Employee employeeB = new Employee(departmentA, "Emp2");
        final Employee employeeC = new Employee(departmentB, "Emp3");

        employeeA.setBoss(employeeC);


        entityManager.persist(companyA);
        entityManager.persist(employeeA);
        entityManager.persist(employeeB);
        entityManager.persist(employeeC);
    }

    public void generateManyToMany() {
        final Student student1 = new Student("st1");
        final Student student2 = new Student("st2");
        final Student student3 = new Student("st3");

        EmbeddedAddress address = new EmbeddedAddress("street", "city", "11111");

        final Course course1 = new Course("eng");
        final Course course2 = new Course("deu");
        final Course course3 = new Course("fr");

        course1.setAddress(address);
        course2.setAddress(address);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        course2.getStudents().add(student2);
        course2.getStudents().add(student3);

        entityManager.persist(course1);
        entityManager.persist(course2);
        entityManager.persist(course3);

    }


    public void query() {
        List<Course> list = dao.getListOfCourses();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getStudents().size(); j++)
                LOGGER.info(list.get(i).getName() + " " + list.get(i).getStudents().get(j).getName());
        }

    }

}
