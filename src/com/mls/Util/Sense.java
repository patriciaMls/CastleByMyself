package com.mls.Util;

import com.mls.creature.Creature;
import com.mls.creature.MonsterWolf;
import com.mls.creature.MonsterWolfSet;
import com.mls.creature.Person;
import com.mls.weapon.WeaponDagger;
import com.mls.weapon.WeaponKnife;
import com.mls.weapon.WeaponSword;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:场景类
 * @author: Patricia
 * @date: Created in 2020/4/29 11:00
 * @version: 1.0
 * @modified By:
 */
public class Sense {
    private Person person = new Person();
    private MonsterWolf wolf1 = new MonsterWolf();
    private MonsterWolf wolf2 = new MonsterWolf();
    private MonsterWolf wolf3 = new MonsterWolf();

    MonsterWolfSet monsterWolfSet = new MonsterWolfSet();

    UI ui = new UI();

    Scanner in = new Scanner(System.in);

    public void initSense(){
        initPerson();

        modeSelection();

    }

    public void initPerson(){
        System.out.println("游戏初始化完成，风趣好玩的RPG场景游戏即将开始……");
        Utils.pauseSeveralSecond(10);
        System.out.println("请输入你的角色名称：");
        this.person.setId("201901234");
        String name = in.nextLine();
        this.person.setDescription(name);

        this.person.setHPValue(300);
        this.ui.printWelcome(this.person);
        this.person.setCurrentWeapon(new WeaponSword("w1","山寨版倚天屠狼剑",-50));
    }

    public void modeSelection(){
        System.out.println("接下来请选择关卡难度模式：地狱模式（v1），普通模式(v2)，简单模式(v3)");
        Utils.pauseSeveralSecond(10);
        System.out.println("请输入（v1、v2或v3）：");
        String mode = in.nextLine();
        if (mode.equals("v1") || mode.equals("V1")){
            System.out.println("已选择地狱模式（v1）");
            initMonsterVer1();
        }else if (mode.equals("v2") || mode.equals("V2")){
            System.out.println("已选择普通模式(v2)");
            initMonsterVer2();
        }else if (mode.equals("v3") || mode.equals("V3")){
            System.out.println("已选择简单模式(v3)");
            initMonsterVer3();
        }else {
            System.out.println("选择错误，默认简单模式（v2）");
            initMonsterVer2();
        }
    }

    public void initMonsterVer1(){
        this.wolf1.setId("wolf1");
        this.wolf1.setDescription("狼1");
        this.wolf1.setHPValue(100);
        this.wolf1.setCurrentWeapon(new WeaponSword("mw1","超高校级的一把剑",-60));

        this.wolf2.setId("wolf2");
        this.wolf2.setDescription("狼2");
        this.wolf2.setHPValue(100);
        this.wolf2.setCurrentWeapon(new WeaponSword("mw2","稍逊一筹的一把剑",-55));

        this.wolf3.setId("wolf3");
        this.wolf3.setDescription("狼3");
        this.wolf3.setHPValue(100);
        this.wolf3.setCurrentWeapon(new WeaponSword("mw3","屠狼剑级的一把剑",-50));

        this.monsterWolfSet.getMonsterWolves().add(wolf1);
        this.monsterWolfSet.getMonsterWolves().add(wolf2);
        this.monsterWolfSet.getMonsterWolves().add(wolf3);
    }

    public void initMonsterVer2(){
        this.wolf1.setId("wolf1");
        this.wolf1.setDescription("狼1");
        this.wolf1.setHPValue(100);
        this.wolf1.setCurrentWeapon(new WeaponKnife("mw1","削铁如泥的一把刀",-50));

        this.wolf2.setId("wolf2");
        this.wolf2.setDescription("狼2");
        this.wolf2.setHPValue(100);
        this.wolf2.setCurrentWeapon(new WeaponKnife("mw2","吹毛刃断的一把刀",-45));

        this.wolf3.setId("wolf3");
        this.wolf3.setDescription("狼3");
        this.wolf3.setHPValue(100);
        this.wolf3.setCurrentWeapon(new WeaponKnife("mw3","切金断玉的一把刀",-40));

        this.monsterWolfSet.getMonsterWolves().add(wolf1);
        this.monsterWolfSet.getMonsterWolves().add(wolf2);
        this.monsterWolfSet.getMonsterWolves().add(wolf3);
    }

    public void initMonsterVer3(){
        this.wolf1.setId("wolf1");
        this.wolf1.setDescription("狼1");
        this.wolf1.setHPValue(100);
        this.wolf1.setCurrentWeapon(new WeaponDagger("mw1","真的很不普通匕首",-40));

        this.wolf2.setId("wolf2");
        this.wolf2.setDescription("狼2");
        this.wolf2.setHPValue(100);
        this.wolf2.setCurrentWeapon(new WeaponDagger("mw2","一点也不普通匕首",-35));

        this.wolf3.setId("wolf3");
        this.wolf3.setDescription("狼3");
        this.wolf3.setHPValue(100);
        this.wolf3.setCurrentWeapon(new WeaponDagger("mw3","和普通无关系匕首",-30));

        this.monsterWolfSet.getMonsterWolves().add(wolf1);
        this.monsterWolfSet.getMonsterWolves().add(wolf2);
        this.monsterWolfSet.getMonsterWolves().add(wolf3);
    }


    public boolean judgeSuccess(){
        boolean flagPersonSuccess = false;
        ArrayList<MonsterWolf> monsterWolfs = this.getMonsterWolfSet().getMonsterWolves();

        if (monsterWolfs.get(0).getHPValue()<=0 &&
                monsterWolfs.get(1).getHPValue()<=0 &&
                monsterWolfs.get(2).getHPValue()<=0){
            flagPersonSuccess=true;
        }
        if (this.getPerson().getHPValue() <= 0){
            flagPersonSuccess = false;
        }

        return flagPersonSuccess;
    }

    public boolean judgeFailed(){
        boolean flagPersonFailed = false;
        if (this.getPerson().getHPValue()<=0){
            flagPersonFailed=true;
        }
        return flagPersonFailed;
    }

    public boolean judgeAttack(Creature attackeCreaure, Creature targetCreature){
        boolean flag = false;
        if (attackeCreaure.getHPValue()>0 && targetCreature.getHPValue()>0){
            flag = true;
        }
        return flag;
    }

    public void gameController(){
        while (true){
            Sense sense=new Sense();
            sense.initSense();
            sense.play();

            System.out.println("----------------你想要退出还是再开一局？----------------");
            System.out.println("退出（exit）/再来一局（next），请输入：");
            String exitOrNot = in.nextLine();
            if (exitOrNot.equals("exit")){
                in.close();
                System.exit(0);
            }else if (exitOrNot.equals("next")){
                continue;
            }else {
                System.out.println("输入有误，默认退出");
                System.out.println("----------------欢迎尝试下一局----------------");
                System.out.println("----------------SEE YOU AGAIN----------------");
            }
        }
    }


    public void play(){
        System.out.println("----------------各位角色攻防汇总展示栏----------------");
        Utils.pauseSeveralSecond(5);
        this.ui.displayStausAll(this);
        Utils.pauseSeveralSecond(10);
        this.ui.displayHelpMsg();

        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("请输入指令：");
            String command = in.nextLine();
            String[] cmdLineItems = command.split(" ");
            String handler = cmdLineItems[0];
            if (handler.equals("bye")){
                this.ui.displayBye();
                break;
            }else if (handler.equals("chop")){
                String value = cmdLineItems[1];
                MonsterWolf wolfBeAttacked = this.getMonsterWolfSet().searchMonsterWolf(value);//获得攻击对象
                if (wolfBeAttacked != null){
                    if (judgeAttack(wolfBeAttacked, this.getPerson())){
                        if (Utils.randomMonsterChop()){
                            wolfBeAttacked.useArticle(wolfBeAttacked.getCurrentWeapon(),this.getPerson());
                            this.ui.displayDamageMsg(wolfBeAttacked, this.getPerson());
                        }else {
                            this.ui.displayDamageFailMsg(wolfBeAttacked, this.getPerson());
                        }
                    }else {
                        System.out.println("该怪物已死亡。");
                    }

                    if (judgeAttack(this.getPerson(),wolfBeAttacked)){
                        this.getPerson().useArticle(this.getPerson().getCurrentWeapon(),wolfBeAttacked);
                        this.ui.displayDamageMsg(this.getPerson(), wolfBeAttacked);
                    }else {
                        System.out.println("攻击失败，对象已死亡。");
                    }
                }else {
                    System.out.println("选择有误，你想攻击的怪物不存在。");
                }

                this.ui.displayStaus(this);
                Utils.pauseSeveralSecond(10);
            }else if (handler.equals("help")){
                this.ui.displayHelpMsg();
            }else {
                System.out.println("指令有误，请再次输入正确的指令。");
                Utils.pauseSeveralSecond(10);
            }

            if (judgeSuccess()){
                System.out.println("----YOU WIN ! ----");
                System.out.println("请输入 'bye' 退出游戏");
            }
            if (judgeFailed()){
                System.out.println("----YOU FAIL ! ----");
                System.out.println("请输入 'bye' 退出游戏");
            }
        }

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public MonsterWolfSet getMonsterWolfSet() {
        return monsterWolfSet;
    }

    public void setMonsterWolfSet(MonsterWolfSet monsterWolfSet) {
        this.monsterWolfSet = monsterWolfSet;
    }
}
