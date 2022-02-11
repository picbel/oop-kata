package com.study.oopkata.domain.monster;

import com.study.oopkata.domain.Stat;
import lombok.Getter;

@Getter
public abstract class Monster extends Stat {
    protected Monster(int level, int hp, int mp, int attackDmg, int defenseDmg) {
        super(level,hp, mp, attackDmg, defenseDmg);
    }


}
