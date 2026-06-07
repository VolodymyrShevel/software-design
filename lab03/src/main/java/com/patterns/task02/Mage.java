package com.patterns.task02;
public class Mage implements Hero {
    private final String name;
    public Mage(String name) { this.name = name; }
    @Override public String getName()        { return name; }
    @Override public int    getAttack()      { return 20; }
    @Override public int    getDefense()     { return 5; }
    @Override public String getDescription() { return "Mage(" + name + ") ATK=" + getAttack() + " DEF=" + getDefense(); }
}
