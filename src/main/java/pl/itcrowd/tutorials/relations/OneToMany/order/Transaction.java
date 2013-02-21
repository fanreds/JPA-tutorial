package pl.itcrowd.tutorials.relations.OneToMany.order;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/21/13
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */


@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {
    @Id
    @SequenceGenerator(name = "TRANSACTION_ID_SEQUENCE", sequenceName = "TRANSACTION_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_ID_SEQUENCE")
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Transaction() {
    }

    public Transaction(String name) {
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
