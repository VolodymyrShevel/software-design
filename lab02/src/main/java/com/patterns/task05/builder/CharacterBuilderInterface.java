package com.patterns.task05.builder;

import com.patterns.task05.character.Character;

public interface CharacterBuilderInterface {
    CharacterBuilderInterface setName(String name);
    CharacterBuilderInterface setHeight(int height);
    CharacterBuilderInterface setBuild(String build);
    CharacterBuilderInterface setHairColor(String color);
    CharacterBuilderInterface setEyeColor(String color);
    CharacterBuilderInterface setOutfit(String outfit);
    CharacterBuilderInterface addInventoryItem(String item);
    CharacterBuilderInterface addDeed(String deed);
    Character build();
}
