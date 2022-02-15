package com.study.oopkata.domain.monster;

import lombok.ToString;

@ToString
public class Slime extends Monster{

    public Slime() {
        super("Slime", 1,100, 0, 300, 10,0.3);
    }
    public Slime(int level) {
        super("Slime",level,100*level, 0, 300*level, 25*level, 0.3);
    }

}
