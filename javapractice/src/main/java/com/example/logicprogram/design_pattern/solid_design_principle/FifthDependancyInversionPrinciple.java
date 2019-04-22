package com.example.logicprogram.design_pattern.solid_design_principle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FifthDependancyInversionPrinciple {

    /*
    * A. High-level module should not depend on low level module.
    * Both should depend on abstraction.
    *
    * B. Abstraction should not depend on details.
    * Details should depend on abstraction.
    * */

    public static void main(String[] args) {
        Person parent = new Person("Girish");
        Person child1 = new Person("Shanu");
        Person child2 = new Person("Bulbul");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}

enum Relationship
{
    PARENT,
    CHILD,
    SIBLING
}

class Person
{
    public String name;

    public Person(String name)
    {
        this.name = name;
    }
}

class RelationTypos
{
    public RelationTypos(Person parent, Relationship relationship, Person child)
    {
        this.parent = parent;
        this.child = child;
        this.relationship = relationship;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }

    public Person getChild() {
        return child;
    }

    public void setChild(Person child) {
        this.child = child;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    private Person parent;
    private Person child;
    private Relationship relationship;
}

/*Adding Abstraction*/
interface RelationshipBrowser
{
    List<RelationTypos> findAllChildrenOf(String name);
}

/*Low Level Module*/
class Relationships implements RelationshipBrowser
{

    /*private List<Triplet<Person,Relationship,Person>> relations
            = new ArrayList<>();*/

    private List<RelationTypos> relations = new ArrayList<>();

    public List<RelationTypos> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child)
    {
        //do thid using tuples
        relations.add(new RelationTypos(parent, Relationship.PARENT, child));
    }

    /*So search we are going to do in low level module
    * Becouse
    * */
    @Override
    public List<RelationTypos> findAllChildrenOf(String name) {
        return relations.stream().filter(parent -> parent.getParent().name.equals(name)
                && parent.getRelationship() == Relationship.PARENT)
                .collect(Collectors.toList());
    }
}


/*High Level Module
* Here Relationships in construction violating the rule : infact it depend on abstraction
* */
class Research
{
    /*public Research(Relationships relationships)
    {
        List<RelationTypos> relations = relationships.getRelations();
        //relations.stream().filter(parent -> parent.getValue0().name.equals("Girish"))   //incase of tuple
        relations.stream().filter(parent -> parent.getParent().name.equals("Girish")
        && parent.getRelationship() == Relationship.PARENT)
                .forEach(child -> System.out.println("\nChild Name : " + child.getChild().name));
    }*/

    public Research(RelationshipBrowser browser)
    {
        browser.findAllChildrenOf("Girish").stream()
                .forEach(child -> System.out.println("\nChild Name : " + child.getChild().name));
    }
}











