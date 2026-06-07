package com.patterns.task02;

public abstract class HeroDecorator implements Hero {
    protected final Hero hero;

    protected HeroDecorator(Hero hero) { this.hero = hero; }

    @Override public String getName()    { return hero.getName(); }
    @Override public int getAttack()     { return hero.getAttack(); }
    @Override public int getDefense()    { return hero.getDefense(); }
}
