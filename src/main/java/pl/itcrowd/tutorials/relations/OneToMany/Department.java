package pl.itcrowd.tutorials.relations.OneToMany;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/21/13
 * Time: 7:49 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable {
    @Id
    @SequenceGenerator(name = "DEPARTMENT_ID_SEQUENCE", sequenceName = "DEPARTMENT_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENT_ID_SEQUENCE")
    private Long id;


    @Column(name = "NAME", nullable = false)
    private String name;


    public Department() {
    }

    public Department(String name) {
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
}
