package com.patterns.task02;

public class RingOfPowerDecorator extends HeroDecorator {
    public RingOfPowerDecorator(Hero hero) { super(hero); }

    @Override public int getAttack()  { return hero.getAttack() + 5; }
    @Override public int getDefense() { return hero.getDefense() + 5; }

    @Override
    public String getDescription() {
        return hero.getDescription() + " + RingOfPower(ATK+5 DEF+5)";
    }
}
