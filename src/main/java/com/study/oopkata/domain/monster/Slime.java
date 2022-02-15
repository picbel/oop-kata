package com.study.oopkata.domain.monster;

public class Slime extends Monster{

    public Slime() {
        super(1,100, 0, 300, 10,0.3);
    }
    public Slime(int level) {
        super(level,100*level, 0, 300*level, 25*level, 0.3);
    }

    public void counterAttack(){
        // 구현

    }

}
