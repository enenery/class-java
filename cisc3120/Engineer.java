package com.enenery.class_game_simulation;
import java.util.ArrayList;
/**
 * Engineer class creates an Engineer object
 * @author Erii Sugimoto.
 */
public class Engineer extends AbstractCharacter{
    private final String ELEMENT_TYPE = "thunder";
    private final String CHARACTER_TYPE = "engineer";

    /**
     * This constructor sets a new Engineer's element, character type, health, attack,
     * skill point, defense, level, and experience and initializes its empty party
     *
     */
    Engineer(){
        setElement();
        setCharType();
        setHealth(BASE_HEALTH);
        setAttack(BASE_ATTACK);
        setSp(BASE_SP);
        setDefense(BASE_DEFENSE);
        setLevel(BASE_LEVEL);
        setExperience(BASE_EXPERIENCE);
        party = new ArrayList<>();
    }

    /**
     * setElement method sets this character's element type
     */
    public void setElement(){
        element = ELEMENT_TYPE;
    }

    /**
     * setCharType method sets this character's character type
     */
    public void setCharType() {charType = CHARACTER_TYPE;}

    /**
     * addBonusHealth method adds 10% bonus to this character's health
     * when there is a member character of the same element type
     */
    @Override
    public void addBonusHealth() {

        for(int i = 0; i<party.size(); i++)
            if(party.get(i).getClass().getName().equalsIgnoreCase("Android"));
        health = (int) Math.ceil(health*1.1);
    }

    /**
     * addBonusAttack method adds bonus to this character's attack
     * when there is a member character of the same element type
     */
    @Override
    public void addBonusAttack() {

        for(int i = 0; i<party.size(); i++)
            if(party.get(i).getClass().getName().equalsIgnoreCase("Android"));
        attack = (int) Math.ceil(attack*1.1);
    }

    /**
     * addBonusSp method adds 10% bonus  points to this character's skill points
     * when there is a member character of a stronger element type
     */
    @Override
    public void addBonusSp() {
        for(int i = 0; i < party.size(); i++) {
            String className = party.get(i).getClass().getName();
            if (className.equalsIgnoreCase("Beastmaster") || className.equalsIgnoreCase("Swordsman")) ;
            sp = (int) Math.ceil(sp * 1.1);
        }
    }

    /**
     * addBonusDefense method adds a 10% bonus to this character's defense
     * when there is a member character of a stronger element type
     */
    @Override
    public void addBonusDefense() {
        for(int i = 0; i<party.size(); i++) {
            String className = party.get(i).getClass().getName();
            if (className.equalsIgnoreCase("Beastmaster") || className.equalsIgnoreCase("Swordsman")) ;
            defense = (int) Math.ceil(defense * 1.1);
        }
    }

    /**
     * addBonusItem method adds a 10% bonus to this character's skill points
     * when there are special items for this character
     */
    @Override
    public void addBonusFromItem() {

        for(int i = 0; i<items.size(); i++)
            for(int j = 0; j < special_Items.size(); j++)
                if(items.get(i).equalsIgnoreCase(special_Items.get(j)));
        sp = (int) Math.ceil(sp*1.1);
    }
}
