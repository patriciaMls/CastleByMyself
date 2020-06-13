package com.mls.Util;

import com.mls.creature.Creature;
import com.mls.creature.MonsterWolf;
import com.mls.creature.MonsterWolfSet;
import com.mls.creature.Person;
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


    public void initSense(){
        initPerson();
        initMonster();
    }

    public void initPerson(){
        this.person.setId("201901234");
        this.person.setDescription("Tony");
        this.person.setHPValue(300);
        this.person.setCurrentWeapon(new WeaponSword("w1","剑",-50));
    }

    public void initMonster(){
        this.wolf1.setId("wolf1");
        this.wolf1.setDescription("狼1");
        this.wolf1.setHPValue(100);
        this.wolf1.setCurrentWeapon(new WeaponKnife("mw1","刀1",-30));

        this.wolf2.setId("wolf2");
        this.wolf2.setDescription("狼2");
        this.wolf2.setHPValue(100);
        this.wolf2.setCurrentWeapon(new WeaponKnife("mw2","刀2",-20));

        this.wolf3.setId("wolf3");
        this.wolf3.setDescription("狼3");
        this.wolf3.setHPValue(100);
        this.wolf3.setCurrentWeapon(new WeaponKnife("mw3","刀3",-25));

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

    public boolean judgeAttack(Creature attackeCreaure, Creature targetCreature){
        boolean flag = false;
        if (attackeCreaure.getHPValue()>0 && targetCreature.getHPValue()>0){
            flag = true;
        }
        return flag;
    }

    public void play(){
        this.ui.printWelcome(this.person);
        this.ui.displayHelpMsg();
        this.ui.displayStaus(this);
        Scanner in = new Scanner(System.in);
        while (true){
            String command = in.nextLine();
            String[] cmdLineItems = command.split(" ");
            String handler = cmdLineItems[0];
            if (handler.equals("bye")){
                this.ui.displayBye();
                break;
            }else if (handler.equals("chop")){
                String value = cmdLineItems[1];
                MonsterWolf wolfBeAttacked = this.getMonsterWolfSet().searchMonsterWolf(value);
                if (wolfBeAttacked != null){
                    if (judgeAttack(this.getPerson(),wolfBeAttacked)){
                        this.getPerson().useArticle(this.getPerson().getCurrentWeapon(),wolfBeAttacked);
                        this.ui.displayDamageMsg(this.getPerson(), wolfBeAttacked);
                    }else {
                        System.out.println("攻击失败，对象已死亡。");
                    }

                    if (Utils.randomMonsterChop()){
                        if (judgeAttack(wolfBeAttacked, this.getPerson())){
                            wolfBeAttacked.useArticle(wolfBeAttacked.getCurrentWeapon(),this.getPerson());
                            this.ui.displayDamageMsg(wolfBeAttacked, this.getPerson());
                        }
                    }else {
                        System.out.println("攻击无效。");
                    }
                }else {
                    System.out.println("error. here have not a MonsterWolf you want to attack.");
                }

                this.ui.displayStaus(this);
            }else if (handler.equals("help")){
                this.ui.displayHelpMsg();
            }else {
                System.out.println("error command. please input command again.");
            }

            if (judgeSuccess()){
                System.out.println("----YOU WIN ! ----");
            }
        }
        in.close();
        System.exit(0);
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
