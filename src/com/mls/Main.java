package com.mls;

import com.mls.Util.Sense;
import com.mls.creature.Creature;
import com.mls.creature.MonsterWolf;
import com.mls.creature.Person;
import com.mls.weapon.Weapon;
import com.mls.weapon.WeaponDagger;

import java.util.Random;
import java.util.Scanner;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/4/29 10:15
 * @version: 1.0
 * @modified By:
 */
public class Main {
    public static void main(String[] args) {
            Sense sense = new Sense();
            sense.gameController();
    }
}
