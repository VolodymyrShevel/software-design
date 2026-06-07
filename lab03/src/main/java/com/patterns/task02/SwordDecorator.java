package com.patterns.task02;

public class SwordDecorator extends HeroDecorator {
    public SwordDecorator(Hero hero) { super(hero); }

    @Override public int getAttack() { return hero.getAttack() + 10; }

    @Override
    public String getDescription() {
        return hero.getDescription() + " + Sword(ATK+10)";
    }
}
