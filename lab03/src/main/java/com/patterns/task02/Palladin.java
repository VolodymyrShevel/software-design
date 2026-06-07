package com.patterns.task02;
public class Palladin implements Hero {
    private final String name;
    public Palladin(String name) { this.name = name; }
    @Override public String getName()        { return name; }
    @Override public int    getAttack()      { return 12; }
    @Override public int    getDefense()     { return 15; }
    @Override public String getDescription() { return "Palladin(" + name + ") ATK=" + getAttack() + " DEF=" + getDefense(); }
}
