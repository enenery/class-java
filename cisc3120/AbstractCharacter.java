package com.enenery.class_game_simulation;
import java.util.*;

/**
 * AbstractCharacter class has basic functions needed for all other characters
 * @author Erii Sugimoto
 */

public abstract class AbstractCharacter implements Character {
    protected ArrayList<String> items;
    protected ArrayList<String> techniques;
    protected ArrayList<AbstractCharacter> party = new ArrayList<>();
    protected Integer health, experience, level, sp, attack, defense;
    protected String element, charType;
    protected boolean selected;
    protected ArrayList<String> special_Items;
    protected ArrayList<String> special_techniques;


    /**
     *  powerup calculates the character's powerup from level
     *  to the next.
     */
    @Override
    public void powerUp() {
        if(getXPForNextLevel(health) <= experience)
            setLevel(level + 1);;
    }

    /**
     * getHealth method returns a character's health
     * @return health
     */
    public Integer getHealth(){return health;}

    /**
     * getAttack method returns a character's attack
     * @return attack
     */
    public Integer getAttack(){return attack;}

    /**
     * getSp method returns a character's skill points
     * @return sp - skill points
     */
    public Integer getSp(){return sp;}

    /**
     * getDefense method returns a character's defense
     * @return defense
     */
    public Integer getDefense(){return defense;}

    /**
     * getElement method returns a character's element
     * @return element - element of a character
     */
    public String getElement(){return element;}

    /**
     * getLevel method returns a character's level
     * @return level - level of a character
     */
    public Integer getLevel(){return level;}

    /**
     * getExperience method returns a character's experience point
     * @return experience - experience point of a character
     */
    public Integer getExperience(){
        return experience;
    }

    /**
     * getItems method returns a character's items
     * @return items
     */
    public ArrayList<String> getItems() {return items;}

    /**
     * getCharType returns a character's type
     * @return
     */
    public String getCharType() {return charType;}

    /**
     * setItems sets items for a character
     * @param items
     */
    public void setItems(ArrayList<String> items) {this.items = items;}

    /**
     * getTechniques returns a character's techniques
     * @return techniques
     */
    public ArrayList<String> getTechniques() {return techniques;}

    /**
     * setTechniques sets a character's techniques
     * @param techniques
     */
    public void setTechniques(ArrayList<String> techniques) {this.techniques = techniques;}

    /**
     * getParty returns a character's party
     * @return
     */
    public ArrayList<AbstractCharacter> getParty() {return party;}

    /**
     * setParty sets a party of a character
     * @param party
     */
    public void setParty(ArrayList<AbstractCharacter> party) {this.party = party;}

    /**
     * setElement sets an element of a character
     * @param element
     */
    public void setElement(String element) {this.element = element;}

    /**
     * setCharType sets a character type of a character
     * @param charType
     */
    public void setCharType(String charType) {this.charType = charType;}

    /**
     * used by Main class for user to select party members
     * @return
     */
    public boolean isSelected() {return selected;}

    /**
     * used by Main class
     * sets a character to be selected by the user
     * @param selected
     */
    public void setSelected(boolean selected) {this.selected = selected;}

    /**
     * @return special_items - s items that can increase a character's skill points
     */
    public ArrayList<String> getSpecial_Items() {return special_Items;}

    /**
     * setSpecial_items sets items that can increase a character's skill points
     * @param special_Items
     */
    public void setSpecial_Items(ArrayList<String> special_Items) {this.special_Items = special_Items;}

    /**
     * @return special_techniques - techniques that can increase a character's skill points
     */
    public ArrayList<String> getSpecial_techniques() {return special_techniques;}

    /**
     * setSpecial_techniques sets techniques that can increase a character's skill points
     * @param special_techniques
     */
    public void setSpecial_techniques(ArrayList<String> special_techniques) {this.special_techniques = special_techniques;}

    /**
     * setHealth method takes in a health value and set it to a character's health
     * @param health
     */
    public void setHealth(Integer health){this.health = health;};

    /**
     * setAttack method takes in an attack value and set it to a character's attack
     * @param attack
     */
    public void setAttack(Integer attack){this.attack = attack;}

    /**
     * setSp method takes in a skill point value and set it to a character's sp
     * @param sp - skill points
     */
    public void setSp(Integer sp){this.sp = sp;}

    /**
     * setDefense method takes in a defense value and set it to a character's defense
     * @param defense
     */
    public void setDefense(Integer defense){this.defense = defense;}

    /**
     * setLevel method takes in a level value and sets it to a character's level
     * @param level
     */
    public void setLevel(Integer level){this.level = level;}

    /**
     * setExperience method takes in a experience value and sets it to a character's experience
     * @param experience
     */
    public void setExperience(Integer experience){this.experience = experience;}

    /**
     * addLevel method takes in a level value and adds it to a character's level
     * @param level
     */
    public void addLevel(Integer level){this.level += level;}

    /**
     * addExperience method takes in a experience value and adds it to a character's experience
     * @param experience
     */
    public void addExperience(Integer experience){this.experience += experience;}


    /**
     * abstract addBonusHealth method adds bonus points for a character's health
     */
    public abstract void addBonusHealth();

    /**
     * abstract addBonusAttack method adds bonus points for a character's attack
     */
    public abstract void addBonusAttack();

    /**
     * abstract addBonusSp method adds bonus points for a character's skill points
     */
    public abstract void addBonusSp();

    /**
     * abstract addBonusDefense method adds bonus points for a character's defense
     */
    public abstract void addBonusDefense();

    /**
     * abstract addBonusFromItem method adds bonus points for a character's skillpoints
     */
    public abstract void addBonusFromItem();


    /**
     * learnItem adds a new item to a character's list of items
     * @param item
     */
    public void addItem(String item){items.add(item);}

    /**
     * useItem removes an item from a character's list of items
     * @param item
     */
    public void useItem(String item){
        int indexOfItem = items.indexOf(item);
        if(indexOfItem != -1)
            items.remove(indexOfItem);}

    /**
     * learnTechnique adds a new technique to a character's list of techniques
     * @param technique
     */
    public void learnTechnique(String technique){techniques.add(technique);}

    /**
     * removeTechnique removes a technique from a character's list of techniques
     * @param technique
     */
    public void removeTechnique(String technique){
        int indexOfTech = techniques.indexOf(technique);
        if(indexOfTech != -1)
            techniques.remove(indexOfTech);
    }

    /**
     * addAMember
     * allows Main class to add members to a calling character's party
     * @param member
     */
    public void addAMember(String member){
            switch (member){
                case "Android":
                    addAndroid();
                    break;
                case "Assassin":
                    addAssassin();
                    break;
                case "Beastmaster":
                    addBeastmaster();
                    break;
                case "Commander":
                    addCommander();
                    break;
                case "Engineer":
                    addEngineer();
                    break;
                case "Healer":
                    addHealer();
                    break;
                case "Huntress":
                    addHuntress();
                    break;
                case "Mariner":
                    addMariner();
                    break;
                case "Soldier":
                    addSoldier();
                    break;
                case "Swordsman":
                    addSwordsman();
                    break;
            }

        }

    /**
     * addMembers assigns a set of party members to a calling character's party
     * @param members
     */
    public void addMembers(ArrayList<AbstractCharacter> members){party = members;}

    //public void addPartyMember(){}
    public void removePartyMember(){}

    public Integer getAttackPower(){return attack;}

    /**
     * addAndroid adds new Android Object to a calling object's party
     */
    public void addAndroid(){
        party.add(new Android());
    }

    /**
     * addAndroid adds new Android Object to a calling object's party
     */
    public void addAssassin(){
        party.add(new Assassin());
    }

    /**
     * addAndroid adds new Android Object to a calling object's party
     */
    public void addBeastmaster(){
        party.add(new Beastmaster());
    }

    /**
     * addAndroid adds new Android Object to a calling object's party
     */
    public void addCommander(){
        party.add(new Commander());
    }

    /**
     * addAndroid adds new Android Object to a calling object's party
     */
    public void addEngineer(){
        party.add(new Engineer());
    }

    /**
     * addAndroid adds new Android Object to a calling object's party
     */
    public void addHealer(){
        party.add(new Healer());
    }

    /**
     * addAndroid adds new Android Object to a calling object's party
     */
    public void addHuntress(){
        party.add(new Huntress());
    }

    /**
     * addMariner adds a new Mariner object to a calling object's party
     */
    public void addMariner(){
        party.add(new Mariner());
    }

    /**
     * addSoldier adds a new Soldier object to a calling object's party
     */
    public void addSoldier(){
        party.add(new Soldier());
    }

    /**
     * addSwordsman adds a new Swordsman object to a calling object's party
     */
    public void addSwordsman(){
        party.add(new Swordsman());
    }

}