package com.study.oopkata.domain.monster;

import com.study.oopkata.domain.Stat;
import lombok.Getter;

@Getter
public abstract class Monster extends Stat {
    protected double countAttackRate;
    protected Monster(int level, int hp, int mp, int attackDmg, int defenseDmg, double countAttackRate) {
        super(level,hp, mp, attackDmg, defenseDmg);
        this.countAttackRate = countAttackRate;
    }


}
