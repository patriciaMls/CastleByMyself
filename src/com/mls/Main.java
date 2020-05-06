package com.mls;

import com.mls.creature.Creature;
import com.mls.weapon.Weapon;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/4/29 10:15
 * @version: 1.0
 * @modified By:
 */
public class Main {
    public static void main(String[] args) {
        Creature creature=new Creature() {
            @Override
            public void useArticle(Weapon weapon, Creature targetCreature) {

            }
        };

    }
}
