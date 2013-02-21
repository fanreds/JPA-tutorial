package pl.itcrowd.tutorials.relations.ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/21/13
 * Time: 10:07 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @SequenceGenerator(name = "COURSE_ID_SEQUENCE", sequenceName = "COURSE_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_ID_SEQUENCE")
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<Student>();

    @Embedded
    private EmbeddedAddress address;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public EmbeddedAddress getAddress() {
        return address;
    }

    public void setAddress(EmbeddedAddress address) {
        this.address = address;
    }
}
