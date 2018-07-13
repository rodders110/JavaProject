package models;

import javax.persistence.*;

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
        this.park = park;
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
    @JoinColumn(name = "park_id", nullable = true)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }
}
