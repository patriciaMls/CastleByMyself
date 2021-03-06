package com.mls.creature;

import com.mls.weapon.Weapon;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/4/29 10:15
 * @version: 1.0
 * @modified By:
 */
public class MonsterWolf extends Creature {

    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        if (targetCreature.getHPValue() > 0){
            weapon.useWeapon(targetCreature);
        }else {
            System.out.println(targetCreature.getDescription()+"已死亡，请另选攻击对象。");
        }
    }
}
