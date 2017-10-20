package com.enenery.class_game_simulation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * AndroidTest class tests methods that work with Android objects
 */
public class AndroidTest {
    private Android android;


    @Before
    public void setUp() throws Exception{
        android = new Android();
    }

    /**
     * checks if setElement method works correctly
     * @throws Exception
     */
    @Test
    public void checkSetElement() throws Exception {
        android.setElement();
        assertEquals(android.element, android.getElement());
    }

    /**
     * checks if setCharType method works correctly
     * @throws Exception
     */
    @Test
    public void checkSetCharType() throws Exception {
        android.setCharType("halo");
        assertEquals(android.charType, android.getCharType());
    }

    /**
     * checks if setHealth method works correctly
     * @throws Exception
     */
    @Test
    public void checkSetHealth() throws Exception {
        android.setHealth(android.BASE_HEALTH);
        assertEquals(Integer.valueOf(android.BASE_HEALTH), android.getHealth());
    }

    /**
     * checks if setAttack method works correctly
     * @throws Exception
     */
    @Test
    public void checkSetAttack() throws Exception {
        android.setHealth(android.BASE_ATTACK);
        assertEquals(Integer.valueOf(android.BASE_ATTACK), android.getAttack());
    }

    /**
     * checks if setDefense method works correctly
     * @throws Exception
     */
    @Test
    public void checkSetDefense() throws Exception {
        android.setHealth(android.BASE_DEFENSE);
        assertEquals(Integer.valueOf(android.BASE_DEFENSE), android.getDefense());
    }

    /**
     * checks if setSp method works correctly
     * @throws Exception
     */
    @Test
    public void checkSetSp() throws Exception {
        android.setSp(android.BASE_SP);
        assertEquals(Integer.valueOf(android.BASE_SP), android.getSp());
    }

    /**
     * checks if setExperience method works correctly
     * @throws Exception
     */
    @Test
    public void checkSetExperience() throws Exception {
        android.setExperience(android.BASE_EXPERIENCE);
        assertEquals(Integer.valueOf(android.BASE_EXPERIENCE), android.getExperience());
    }

    /**
     * checks if addBonusHealth adds a 10% bonus when there is an Engineer in the party
     * @throws Exception
     */
    @Test
    public void addBonusHealthTest() throws Exception {
        Integer initHealth = android.getHealth();
        android.addEngineer();
        android.addBonusHealth();
        Integer newHealth = (int) Math.ceil(initHealth*1.1);
        assertEquals(newHealth, android.getHealth());
    }

    /**
     * checks if addBonusAttack adds a 10% bonus when there is an Engineer in the party
     * @throws Exception
     */
    @Test
    public void addBonusAttackTest() throws Exception {
        Integer initAttack = android.getAttack();
        android.addEngineer();
        android.addBonusAttack();
        Integer newAttack = (int) Math.ceil(initAttack*1.1);
        assertEquals(newAttack, android.getAttack());
    }

    /**
     * checks if addBonusSp adds a 10% bonus when there is a Beastmaster in the party
     * @throws Exception
     */
    @Test
    public void checkAddBonusSpForOneMatch() throws Exception {
        Integer initSp = android.getSp();
        android.addBeastmaster();
        android.addBonusSp();
        Integer newSp = (int) Math.ceil(initSp*1.1);
        assertEquals(newSp, android.getSp());
    }

    /**
     * checks if addBonusSp adds a 10% bonus when there is a Beastmaster in the party
     * and adds another 10% bonus when there is a Swordsman in the party
     * @throws Exception
     */
    @Test
    public void addBonusSpForTwoMatchTest()  throws Exception {
        Integer initSp = android.getSp();
        android.addBeastmaster();
        android.addSwordsman();
        android.addBonusSp();
        Integer newSp = (int) Math.ceil(initSp*1.1);
        newSp = (int) Math.ceil(newSp*1.1);
        assertEquals(newSp, android.getSp());
    }

    /**
     * checks if getXPForNextLevel returns correct value
     * @throws Exception
     */
    @Test
    public void checkGetXPForNextLevel() throws Exception {
        Integer hp = android.getHealth();
        assertEquals(Integer.valueOf((int) Math.ceil((hp/20)^2)) , android.getXPForNextLevel(hp));
    }

    /**
     * checks if power up does not power up when experience point is 0, which is the BASE_EXPERIENCE
     * @throws Exception
     */
    @Test
    public void checkPowerUpForNotLevelingUp() throws Exception {
        android.setExperience(android.BASE_EXPERIENCE);
        android.powerUp();
        assertEquals(Integer.valueOf(android.BASE_LEVEL), android.getLevel());
    }

    /**
     * checks if power up levels up from level 1, when experience point is 625, which is required for the level 2
     * @throws Exception
     */
    @Test
    public void checkPowerUpForLevelingUp() throws Exception {
        android.setHealth(android.BASE_HEALTH);
        android.setExperience(625);
        android.powerUp();
        assertEquals(Integer.valueOf(2), android.getLevel());
    }
}