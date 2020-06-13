package com.mls.weapon;

import com.mls.creature.Creature;

/**
 * @description:刀
 * @author: Patricia
 * @date: Created in 2020/4/29 10:52
 * @version: 1.0
 * @modified By:
 */
public class WeaponKnife extends Weapon{
    public WeaponKnife(String id, String description, int damagePoints) {
        super(id, description, damagePoints);
    }

    @Override
    public void useWeapon(Creature enemyCreature) {

        enemyCreature.setHPValue(enemyCreature.getHPValue()+this.getDamagePoints());
    }
}
