package pl.itcrowd.tutorials.relations.OneToMany;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/21/13
 * Time: 7:50 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @SequenceGenerator(name = "EMPLOYEE_ID_SEQUENCE", sequenceName = "EMPLOYEE_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_ID_SEQUENCE")
    private Long id;


    @JoinColumn(name = "DEPARTMENT_ID")
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private Department department;

    @JoinColumn(name = "BOSS_ID")
    @ManyToOne(optional = true)
    private Employee boss;

    @Column(name = "NAME")
    private String name;

    public Employee() {
    }

    public Employee(Department department, String name) {
        this.department = department;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department departments) {
        this.department = departments;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

