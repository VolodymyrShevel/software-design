package com.patterns.task05.builder;
import com.patterns.task05.character.Character;
import java.util.*;
public class EnemyBuilder implements CharacterBuilderInterface {
    private final Character character = new Character();
    private final List<String> inventory = new ArrayList<>();
    private final List<String> deeds = new ArrayList<>();
    public EnemyBuilder() { character.setFaction("enemy"); }
    @Override public EnemyBuilder setName(String n)        { character.setName(n); return this; }
    @Override public EnemyBuilder setHeight(int h)         { character.setHeight(h); return this; }
    @Override public EnemyBuilder setBuild(String b)       { character.setBuild(b); return this; }
    @Override public EnemyBuilder setHairColor(String c)   { character.setHairColor(c); return this; }
    @Override public EnemyBuilder setEyeColor(String c)    { character.setEyeColor(c); return this; }
    @Override public EnemyBuilder setOutfit(String o)      { character.setOutfit(o); return this; }
    @Override public EnemyBuilder addInventoryItem(String i){ inventory.add(i); return this; }
    @Override public EnemyBuilder addDeed(String d)        { deeds.add("[EVIL] " + d); return this; }
    public EnemyBuilder addEvilDeed(String d)              { return addDeed(d); }
    @Override public Character build() { character.setInventory(new ArrayList<>(inventory)); character.setDeeds(new ArrayList<>(deeds)); return character; }
}
