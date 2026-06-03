package com.patterns.task05.character;
import java.util.List;
public class Character {
    private String name, build, hairColor, eyeColor, outfit, faction;
    private int height;
    private List<String> inventory, deeds;
    public void setName(String v)      { name = v; }
    public void setHeight(int v)       { height = v; }
    public void setBuild(String v)     { build = v; }
    public void setHairColor(String v) { hairColor = v; }
    public void setEyeColor(String v)  { eyeColor = v; }
    public void setOutfit(String v)    { outfit = v; }
    public void setInventory(List<String> v) { inventory = v; }
    public void setDeeds(List<String> v)     { deeds = v; }
    public void setFaction(String v)   { faction = v; }
    @Override
    public String toString() {
        return String.format("""
                === Character: %s [%s] ===
                  Height    : %d cm
                  Build     : %s
                  Hair      : %s
                  Eyes      : %s
                  Outfit    : %s
                  Inventory : %s
                  Deeds     : %s
                """, name, faction, height, build, hairColor, eyeColor, outfit, inventory, deeds);
    }
}
