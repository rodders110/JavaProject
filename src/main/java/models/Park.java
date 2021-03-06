package models;

import db.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parks")
public class Park {

    private int id;
    private String name;
    private int totalVisitors;
    private List<Paddock> paddocks;
    private  List<Visitor> visitors;
    private boolean rampage;

    public Park() {
    }

    public Park(String name) {
        this.name = name;
        this.totalVisitors = 0;
        this.rampage = false;
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

    @Column(name = "total_visitors")
    public int getTotalVisitors() {
        return totalVisitors;
    }

    public void setTotalVisitors(int totalVisitors) {
        this.totalVisitors = totalVisitors;
    }

    @OneToMany(mappedBy = "park", fetch = FetchType.LAZY)
    public List<Paddock> getPaddocks() {
        return paddocks;
    }

    public void setPaddocks(List<Paddock> paddocks) {
        this.paddocks = paddocks;
    }

    @OneToMany(mappedBy = "park", fetch = FetchType.LAZY)
    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    @Column(name = "isRampage")
    public boolean isRampage() {
        return rampage;
    }

    public void setRampage(boolean rampage) {
        this.rampage = rampage;
    }

    public void addPaddock(Paddock paddock){
        this.paddocks.add(paddock);
    }

    public void addVisitor (Visitor visitor){
        visitor.setPark(this);
        this.totalVisitors++;
    }


    public void exitVisitor (Visitor visitor){
        this.visitors.remove(visitor);
    }

    public void evacuate(){
        this.visitors.clear();
    }

    public void moveDino(Paddock paddock_From, Paddock paddock_To, Dinosaur dinosaur){
        if ((dinosaur.getClass() == paddock_To.getDinosaurs().get(0).getClass()) || (paddock_To.getDinosaurs().size() == 0)){
            paddock_From.getDinosaurs().remove(dinosaur);
            paddock_To.addDinosaur(dinosaur);
        }
    }

    public void checkRampage(){
        List<Paddock> paddocksList = DBPaddock.allPaddocks(this);
        List<Visitor> visitors = DBVisitor.allVisitors(this);
        for (Paddock paddock : paddocksList){
            if (paddock.getIntegrity() <= 0){
                List<Dinosaur> dinosaurs = DBPaddock.getDinosInPaddock(paddock);
                for (Dinosaur dino : dinosaurs){


                   String check = dino.getSpecies().toString();
                    if (dino.getClass().toString().equals("class models.Carnivore")) {
                        dino.setBelly(19);
                    }
                    dino.setInCaptivity(false);
                    DBHelper.update(dino);
                }
                this.setRampage(true);
                for (Visitor visitor : visitors){
                    DBHelper.delete(visitor);
                }
            }
        }
    }

    public int count(Park park){
        List<Visitor> visitors = DBVisitor.allVisitors(park);
        return visitors.size();
    }
}
