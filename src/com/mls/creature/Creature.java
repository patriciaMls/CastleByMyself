package com.mls.creature;

import com.mls.weapon.Weapon;

import java.util.ArrayList;

/**
 * @description:生物父类
 * @author: Patricia
 * @date: Created in 2020/4/29 10:14
 * @version: 1.0
 * @modified By:
 */
//abstract 抽象类，不能实例化
public abstract class Creature {
    private String id;
    private String description;
    private int HPValue;
    private Weapon currentWeapon;

    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();

    //生物拥有装备，装备应该是Creature类的一个属性
    //使用weapon，并作用于targetCreature
    //abstract 申明的功能，没有实现
    //原因，不同的生物如何使用工具，具体的方法，很有可能是不一样的，因此在生物确定之前，只能写一个申明
    //useArticle方法是一个抽象方法
    public abstract void useArticle(Weapon weapon, Creature targetCreature);

    public Creature() {
    }

    public Creature(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Creature(String id, String description, int HPValue) {
        this.id = id;
        this.description = description;
        this.HPValue = HPValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHPValue() {
        return HPValue;
    }

    public void setHPValue(int HPValue) {
        this.HPValue = HPValue;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
}
