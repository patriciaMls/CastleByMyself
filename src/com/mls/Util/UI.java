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
        System.out.println("亲爱的 "+person.getDescription()+" 玩家，欢迎来到RPG版砍怪游戏！");
        Utils.pauseSeveralSecond(10);
//        System.out.println("这是一个有趣且好玩的*采取了回合制*融入RPG元素*砍怪但不升级*低危易生存*游戏。");
        System.out.printf("这是一个有趣且好玩的");
        Utils.pauseSeveralSecond(5);
        System.out.printf("*采取了回合制");
        Utils.pauseSeveralSecond(5);
        System.out.printf("*融入RPG元素");
        Utils.pauseSeveralSecond(5);
        System.out.printf("*砍怪但不升级");
        Utils.pauseSeveralSecond(5);
        System.out.printf("*低危易生存*游戏");
        Utils.pauseSeveralSecond(10);
        System.out.println();
        System.out.println("如果需要帮助，请输入 'help' 。");
        Utils.pauseSeveralSecond(10);
        System.out.println();
    }

    public void displayStaus(Sense sense){
        System.out.println("______________________________________________");
        System.out.println(sense.getPerson().getDescription()+":"+sense.getPerson().getHPValue());
        for (MonsterWolf item : sense.getMonsterWolfSet().getMonsterWolves()){
            System.out.print(item.getId()+"("+item.getDescription()+"):"+item.getHPValue()+"  ");
        }
        System.out.println("\n______________________________________________\n");
    }

    public void displayStausAll(Sense sense){
        System.out.println("__________________________________________________");
        System.out.println("玩家:");
        System.out.print(sense.getPerson().getDescription()+" HP:"+sense.getPerson().getHPValue()+
                "，攻击力："+(-sense.getPerson().getCurrentWeapon().getDamagePoints())+"，");
        System.out.println("使用武器为"+sense.getPerson().getCurrentWeapon().getDescription());
        System.out.println("敌方:");
        for (MonsterWolf item : sense.getMonsterWolfSet().getMonsterWolves()){
            System.out.print(item.getId()+"("+item.getDescription()+")HP:"+item.getHPValue()+
                    "，攻击力："+(-item.getCurrentWeapon().getDamagePoints())+"，");
            System.out.println("使用武器为"+item.getCurrentWeapon().getDescription());
        }
        System.out.println("__________________________________________________\n");

    }

    public void displayHelpMsg(){
        System.out.println("----可使用的3条指令: chop(chop wolf1) bye help----");
        Utils.pauseSeveralSecond(10);
    }

    public void displayBye(){
        System.out.println("---BYE----");
    }

    public void displayDamageMsg(Creature attackCreature, Creature targetCreature){

        System.out.println(attackCreature.getDescription()+" 对 "+targetCreature.getDescription()+
                " 进行攻击，造成 "+attackCreature.getCurrentWeapon().getDamagePoints()+" 伤害。");
        Utils.pauseSeveralSecond(10);

        if (targetCreature instanceof MonsterWolf && targetCreature.getHPValue()==50){
            displayWolfLastWordOfWolf1(targetCreature);
            Utils.pauseSeveralSecond(5);
            diaplayPlayerWord1(attackCreature);
        }else if (targetCreature instanceof MonsterWolf && targetCreature.getHPValue()==0){
            displayWolfLastWordOfWolf2(targetCreature);
            Utils.pauseSeveralSecond(5);
            diaplayPlayerWord2(attackCreature);
        }

        Utils.pauseSeveralSecond(10);
    }

    public void displayDamageFailMsg(Creature attackCreature, Creature targetCreature){
        System.out.println(attackCreature.getDescription()+" 对 "+targetCreature.getDescription()+
                " 进行攻击，攻击无效。");
        Utils.pauseSeveralSecond(10);
    }

    public void diaplayPlayerWord1(Creature player){
        System.out.println(player.getDescription()+": 哇呀呀呀——少废话！看你往哪里逃，接招！");
    }

    public void diaplayPlayerWord2(Creature player){
        System.out.println(player.getDescription()+": 胜利必将是属于我的！哈哈哈——");
    }

    public void displayWolfLastWordOfWolf1(Creature creatureBeAttacked){
        System.out.println(creatureBeAttacked.getDescription()+": 你为什么要攻击我？既然这样我也就不会对你客气了！喝啊！");
    }
    public void displayWolfLastWordOfWolf2(Creature creatureBeAttacked){
        System.out.println(creatureBeAttacked.getDescription()+": 啊，我死了！你可真不留情面啊……");
    }
}
