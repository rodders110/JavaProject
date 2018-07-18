package models;

import db.DBHelper;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="visitors")
public class Visitor {

    private int id;
    private String  name;
    private Park park;


    public Visitor() {
    }

    public Visitor(String name) {

        this.name = name;
        this.park = null;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void feed(IEat dinosaur, FoodType food){

        dinosaur.eat(food);

    }

    @ManyToOne
    @JoinColumn(name = "park_id", nullable = false)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    private int count(Park park){
        List<Visitor> visitors = DBHelper.find(Visitor.class, park.getId());
        return visitors.size();
    }
}
