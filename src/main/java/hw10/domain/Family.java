package hw10.domain;

import hw10.domain.Human;
import hw10.domain.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Family {
    private Human father;
    private Human mother;
    private ArrayList<Human> children;
    private Set<Pet> pets;

    public Family() { }

    public Family(Human father, Human mother, Set<Pet> pets){
        this.father=father;
        this.mother=mother;
        this.mother.setFamily(this);
        this.father.setFamily(this);
        this.pets=pets;
    }

    public Family(Human father, Human mother){
        this.father=father;
        this.mother=mother;
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Human getFather() { return father; }

    public Human getMother() {
        return mother;
    }

    public ArrayList<Human> getChildren() {
        if (children == null) return new ArrayList<>();
        return children;
    }

    public Set<Pet> getPet() {
        return pets;
    }

    public void addChild(Human newChild){
        newChild.setFamily(this);
        if (children != null) {
            ArrayList<Human> tempChildren = new ArrayList<>(children.size()+1);
            for (Human child : children) {
                tempChildren.addAll(Collections.singleton(child));
            }
            tempChildren.add(tempChildren.size()-1,newChild);
            children=tempChildren;
        } else {
            children= new ArrayList<>(Collections.singleton(newChild));
        }
    }

    boolean deleteChild(Human child){
        if (children == null || child == null) return false;
        int childIndex = -1;
        for (int i = 0; i<children.size();i++) {
            if (children.contains(child)) {
                childIndex = i;
                break;
            }
        }
        if (childIndex == -1) {
            return  false;
        } else {
            ArrayList<Human> tempChildren = new ArrayList<>(children.size() - 1);
            for (int i = 0; i<children.size(); i++) {
                if (i != childIndex) {
                    tempChildren = children;
                    break;
                }
            }
            children = tempChildren;
            return true;
        }
    }


    public int countFamily(){
        if (children==null) return 2;
        return children.size()+2;
    }

    public String represent(int i){
        return
        String.format("Family %d : %s",i,this);
    }


    @Override
    public String toString(){
        return String.format("Human{Father name='%s', Father surname='%s', year='%s', Mother name='%s', Mother surname='%s', year='%s', Children='%s', Pet=[%s]}\n",
                father.getName(),father.getSurname(),father.birthDateToString(),
                mother.getName(),mother.getSurname(),mother.birthDateToString(),
                children,pets);
    }
}
