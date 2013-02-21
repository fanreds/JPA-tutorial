package pl.itcrowd.tutorials.elementCollection;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/21/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Ensemble implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ElementCollection
    private List<String> songs = new ArrayList<String>();

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

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public Ensemble() {

    }

    public Ensemble(String name) {

        this.name = name;
    }
}
