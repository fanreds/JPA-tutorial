package pl.itcrowd.tutorials.relations.OneToOne;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/20/13
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "ADDRESS_ID_SEQUENCE", sequenceName = "ADDRESS_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_ID_SEQUENCE")
    private Integer id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIPCODE")
    private String zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;

    public Address(String street, String city, String zipCode, Person person) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.person = person;
    }

    public Address() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
