package models;

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
        this.paddocks = new ArrayList<Paddock>();
        this.visitors = new ArrayList<Visitor>();
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

    @Column(name = "paddocks")
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
        this.visitors.add(visitor);
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

    public boolean checkRampage(){
        for (Paddock paddock : paddocks){
            if (paddock.getIntegrity() <= 0){
                this.setRampage(true);
            }
        }
        return  rampage;

    }
}
