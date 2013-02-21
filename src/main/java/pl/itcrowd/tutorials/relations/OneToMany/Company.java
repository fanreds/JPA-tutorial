package pl.itcrowd.tutorials.relations.OneToMany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/21/13
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Department> departments = new ArrayList<Department>();

    @Id
    @SequenceGenerator(name = "COMPANY_ID_SEQUENCE", sequenceName = "COMPANY_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_ID_SEQUENCE")
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
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