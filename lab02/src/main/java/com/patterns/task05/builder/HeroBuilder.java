package com.patterns.task05.builder;
import com.patterns.task05.character.Character;
import java.util.*;
public class HeroBuilder implements CharacterBuilderInterface {
    private final Character character = new Character();
    private final List<String> inventory = new ArrayList<>();
    private final List<String> deeds = new ArrayList<>();
    public HeroBuilder() { character.setFaction("hero"); }
    @Override public HeroBuilder setName(String n)        { character.setName(n); return this; }
    @Override public HeroBuilder setHeight(int h)         { character.setHeight(h); return this; }
    @Override public HeroBuilder setBuild(String b)       { character.setBuild(b); return this; }
    @Override public HeroBuilder setHairColor(String c)   { character.setHairColor(c); return this; }
    @Override public HeroBuilder setEyeColor(String c)    { character.setEyeColor(c); return this; }
    @Override public HeroBuilder setOutfit(String o)      { character.setOutfit(o); return this; }
    @Override public HeroBuilder addInventoryItem(String i){ inventory.add(i); return this; }
    @Override public HeroBuilder addDeed(String d)        { deeds.add("[GOOD] " + d); return this; }
    public HeroBuilder addGoodDeed(String d)              { return addDeed(d); }
    @Override public Character build() { character.setInventory(new ArrayList<>(inventory)); character.setDeeds(new ArrayList<>(deeds)); return character; }
}
