package com.enenery.class_game_simulation;
/**
 *
 * @author Erii
 *
 * The following interface is an API for all common Characters.
 * Most characteristics must be implemented.
 *
 */
public interface Character {
    int BASE_HEALTH = 500;
    int BASE_ATTACK = 100;
    int BASE_DEFENSE = 100;
    int BASE_SP = 100;
    int BASE_EXPERIENCE = 0;
    int BASE_LEVEL = 1;

        /**
         *  powerUp increments a character's level by 1 if
         *  a character has experience points required to go to the next level
         */
        void powerUp();

        /**
         *  getXPForNextLevel
         *  Based on a character's health points, we calculate the experience for next level.
         * @param hp -  a character's health points.
         * @return xp - experience points needed for a character to go to the next level.
         */
        default Integer getXPForNextLevel(Integer hp)
        {
            Integer xp = (int) Math.ceil((hp/20)^2);
            return xp;
        }


}
