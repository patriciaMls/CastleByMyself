package com.mls.weapon;

import com.mls.creature.Creature;

/**
 * @description:匕首
 * @author: Patricia
 * @date: Created in 2020/4/29 10:53
 * @version: 1.0
 * @modified By:
 */
public class WeaponDagger extends Weapon {
    //给敌方生物的生命值造成伤害
    //匕首dagger的使用方法，修改enemyCreature的HP
    @Override
    public void useWeapon(Creature enemyCreature) {
        enemyCreature.setHPValue(enemyCreature.getHPValue()+this.getDamagePoints());
    }
}
