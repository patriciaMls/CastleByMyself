package com.mls.Util;

import java.util.Random;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/6/14 1:31
 * @version: 1.0
 * @modified By:
 */
public class Utils {
    public static boolean randomMonsterChop(){
        Random random = new Random();
        boolean flag = false;
        int randomInt = random.nextInt()*10;
        //0-10 012 3456789
        if (randomInt >= 3){
            flag = true;
        }
        return flag;
}
}
