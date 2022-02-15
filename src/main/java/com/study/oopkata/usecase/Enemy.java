package com.study.oopkata.usecase;

import com.study.oopkata.domain.Stat;
import com.study.oopkata.domain.monster.Monster;
import com.study.oopkata.domain.monster.Slime;

public class Enemy implements Behavior{

    Monster monster;

    public Enemy(Monster monster) {
        this.monster = monster;
    }

    @Override
    public boolean attackDelay() {
        return false;
    }

    @Override
    public boolean beHit(Stat attacker) {
        monster.minusHp(calculateDamage(attacker, monster));
        return false;
    }
}
