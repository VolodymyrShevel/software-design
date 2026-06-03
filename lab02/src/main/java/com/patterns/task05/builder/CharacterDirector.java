package com.patterns.task05.builder;
import com.patterns.task05.character.Character;
public class CharacterDirector {
    public Character buildHero(HeroBuilder builder) {
        return builder
                .setName("Artem the Bright").setHeight(185).setBuild("athletic")
                .setHairColor("blond").setEyeColor("blue").setOutfit("shining paladin armor")
                .addInventoryItem("Sword of Light").addInventoryItem("Shield of Truth").addInventoryItem("Healing potion x5")
                .addGoodDeed("Saved the city from a dragon")
                .addGoodDeed("Helped villagers rebuild their homes")
                .addGoodDeed("Defeated the dark wizard")
                .build();
    }
    public Character buildEnemy(EnemyBuilder builder) {
        return builder
                .setName("Shadow the Dark").setHeight(200).setBuild("massive")
                .setHairColor("black").setEyeColor("red").setOutfit("dark spiked armor")
                .addInventoryItem("Cursed sword").addInventoryItem("Amulet of darkness").addInventoryItem("Poison x10")
                .addEvilDeed("Destroyed three cities")
                .addEvilDeed("Stole the artifact of Light")
                .addEvilDeed("Commanded an army of undead")
                .build();
    }
}
