package com.study.oopkata.domain.monster;

import com.study.oopkata.domain.Stat;
import com.study.oopkata.util.RandomEventUtil;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
public abstract class Monster extends Stat {
    protected double countAttackRate;
    protected Monster(String race, int level, int hp, int mp, int attackDmg, int defenseDmg, double countAttackRate) {
        super(race, level,hp, mp, attackDmg, defenseDmg);
        this.countAttackRate = countAttackRate;
    }

    public boolean isCounter(){
        return RandomEventUtil.randomEventResult(countAttackRate);
    }

    public int getCountAttackDamage(){
        return (int) (getAttackDmg()*0.7);
    }
}
