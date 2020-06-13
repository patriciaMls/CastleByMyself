package com.mls.weapon;

import com.mls.creature.Creature;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/4/29 10:15
 * @version: 1.0
 * @modified By:
 */
public abstract class Weapon {
    private String id;
    private String description;
    private int damagePoints;

    //使用道具
    public abstract void useWeapon(Creature enemyCreature);

    public Weapon() {
    }

    public Weapon(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Weapon(String id, String description, int damagePoints) {
        this.id = id;
        this.description = description;
        this.damagePoints = damagePoints;
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

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }
}
