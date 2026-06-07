package com.patterns.task02;

public class ArmorDecorator extends HeroDecorator {
    public ArmorDecorator(Hero hero) { super(hero); }

    @Override public int getDefense() { return hero.getDefense() + 15; }

    @Override
    public String getDescription() {
        return hero.getDescription() + " + Armor(DEF+15)";
    }
}
