package com.study.oopkata.usecase;

import com.study.oopkata.domain.Stat;
import com.study.oopkata.domain.monster.Monster;


public class Enemy implements Behavior{

    Monster monster;

    public Enemy(Monster monster) {
        this.monster = monster;
    }

    @Override
    public boolean attackDelay() {
        return false;
    }

    // 방어 따로 공격따로로 해야하나...? 고민중
    @Override
    public <T extends Stat> void beHit(T attacker) {
        monster.minusHp(calculateDamage(attacker.getAttackDmg(), monster));
        if (monster.isCounter()){
            attacker.minusHp(calculateDamage(monster.getCountAttackDamage(),attacker));
        }
    }


}
