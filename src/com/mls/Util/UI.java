package com.mls.Util;

import com.mls.creature.Creature;
import com.mls.creature.MonsterWolf;
import com.mls.creature.Person;

/**
 * @description:交互界面
 * @author: Patricia
 * @date: Created in 2020/6/14 0:42
 * @version: 1.0
 * @modified By:
 */
public class UI {
    public void printWelcome(Person person){
        System.out.println();
        System.out.println(person.getDescription()+"，欢迎来到砍怪游戏！");
        System.out.println("这是一个好玩的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
    }

    public void displayStaus(Sense sense){
        System.out.println("______________________________________________");
        System.out.println(sense.getPerson().getDescription()+":"+sense.getPerson().getHPValue());
        for (MonsterWolf item : sense.getMonsterWolfSet().getMonsterWolves()){
            System.out.print(item.getId()+"("+item.getDescription()+"):"+item.getHPValue()+"  ");
        }
        System.out.println("\n______________________________________________");
    }

    public void displayHelpMsg(){
        System.out.println("----可使用的3条指令: chop(chop wolf1) bye help----");

    }

    public void displayBye(){
        System.out.println("---BYE----");
    }

    public void displayDamageMsg(Creature attackCreature, Creature targetCreature){
        System.out.println(attackCreature.getDescription()+"对"+targetCreature.getDescription()+"进行攻击，造成"+attackCreature.getCurrentWeapon().getDamagePoints()+"伤害。");

    }
}
