package com.mls.creature;

import java.util.ArrayList;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/4/29 11:03
 * @version: 1.0
 * @modified By:
 */
public class MonsterWolfSet {
    private ArrayList<MonsterWolf> monsterWolves = new ArrayList<>();

    //增删改查

    public MonsterWolf searchMonsterWolf(String id){
        MonsterWolf monsterWolf = null;
        for (MonsterWolf item : this.monsterWolves){
            if (true == id.equals(item.getId())){
                monsterWolf = item;
                break;
            }
        }
        return monsterWolf;
    }
    public MonsterWolfSet() {
    }

    public MonsterWolfSet(ArrayList<MonsterWolf> monsterWolves) {
        this.monsterWolves = monsterWolves;
    }

    public ArrayList<MonsterWolf> getMonsterWolves() {
        return monsterWolves;
    }

    public void setMonsterWolves(ArrayList<MonsterWolf> monsterWolves) {
        this.monsterWolves = monsterWolves;
    }
}
