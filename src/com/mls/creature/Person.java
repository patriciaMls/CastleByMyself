package com.mls.creature;

import com.mls.weapon.Weapon;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/4/29 10:15
 * @version: 1.0
 * @modified By:
 */
public class Person extends Creature {
    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        weapon.useWeapon(targetCreature);
    }
}
