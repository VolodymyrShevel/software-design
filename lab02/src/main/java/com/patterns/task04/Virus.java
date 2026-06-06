package com.patterns.task04;
import java.util.ArrayList;
import java.util.List;
public class Virus implements Cloneable {
    private double weight;
    private int age;
    private String name;
    private String species;
    private List<Virus> children;
    
    public Virus(String name, String species, double weight, int age) {
        this.name = name; this.species = species; this.weight = weight; this.age = age;
        this.children = new ArrayList<>();
    }
    public void addChild(Virus child) { children.add(child); }
    
    @Override
    public Virus clone() {
        try {
            Virus copy = (Virus) super.clone();
            copy.children = new ArrayList<>();
            for (Virus child : this.children) copy.children.add(child.clone());
            return copy;
        } catch (CloneNotSupportedException e) { throw new RuntimeException("Clone failed", e); }
    }
    public void print(String indent) {
        System.out.printf("%s[%s] species=%s, weight=%.4f, age=%d%n", indent, name, species, weight, age);
        for (Virus child : children) child.print(indent + "  ");
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Virus> getChildren() { return children; }
}
