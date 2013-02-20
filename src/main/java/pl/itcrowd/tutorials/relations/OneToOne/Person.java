package pl.itcrowd.tutorials.relations.OneToOne;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/20/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
    @Id
    @SequenceGenerator(name = "PERSON_ID_SEQUENCE", sequenceName = "PERSON_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_ID_SEQUENCE")
    private Integer idd;

    @Column(name = "NAME")
    private String name;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Address address;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Integer getIdd() {
        return idd;
    }

    public void setIdd(Integer id) {
        this.idd = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
