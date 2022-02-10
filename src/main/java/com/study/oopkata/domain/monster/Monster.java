package com.study.oopkata.domain.monster;

import com.study.oopkata.domain.Stat;

public abstract class Monster extends Stat {


    protected Monster(int hp, int mp, int attackDmg, int defenseDmg) {
        super(hp, mp, attackDmg, defenseDmg);
    }
}
