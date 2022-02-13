package com.study.oopkata.util;

import java.util.SplittableRandom;

public class randomEventUtil {
    private randomEventUtil() { }

    public static boolean randomEventResult(double persent){
        // 100%와 0%경우에 예외처리를 해야할지 지금 처럼 리턴을 해야할지 고민.
        if (persent >= 1){return true;}
        if (persent <= 0){return false;}

        return generateRandomInt() <= persent*100;
    }

    protected static int generateRandomInt(){
        SplittableRandom random = new SplittableRandom();
        return random.nextInt(1, 101);
    }
}
