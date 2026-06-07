package com.patterns.task02;
public class Warrior implements Hero {
    private final String name;
    public Warrior(String name) { this.name = name; }
    @Override public String getName()        { return name; }
    @Override public int    getAttack()      { return 15; }
    @Override public int    getDefense()     { return 10; }
    @Override public String getDescription() { return "Warrior(" + name + ") ATK=" + getAttack() + " DEF=" + getDefense(); }
}
