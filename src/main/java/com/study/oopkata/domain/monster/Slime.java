package com.study.oopkata.domain.monster;

public class Slime extends Monster{

    public Slime() {
        super(1,100, 0, 300, 10,0.7);
    }
    public Slime(int level) {
        super(level,100*level, 0, 300*level, 10*level, 0.7);
    }
}
