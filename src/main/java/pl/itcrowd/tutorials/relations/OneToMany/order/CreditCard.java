package pl.itcrowd.tutorials.relations.OneToMany.order;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/21/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CREDITCARD")
public class CreditCard implements Serializable {
    @Id
    @SequenceGenerator(name = "CREDITCARD_ID_SEQUENCE", sequenceName = "CREDITCARD_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CREDITCARD_ID_SEQUENCE")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OrderColumn
    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactionsHistory = new ArrayList<Transaction>();

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

    public List<Transaction> getTransactionsHistory() {
        return transactionsHistory;
    }

    public void setTransactionsHistory(List<Transaction> transactionsHistory) {
        this.transactionsHistory = transactionsHistory;
    }

    public CreditCard() {

    }

    public CreditCard(String name) {

        this.name = name;
    }
}
