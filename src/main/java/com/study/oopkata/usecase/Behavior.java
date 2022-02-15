package com.study.oopkata.usecase;

import com.study.oopkata.domain.Stat;

public interface Behavior {

    void beHit(int attackerDamage);

    default int calculateDamage(int attackerDmage, Stat defender){
        return attackerDmage - defender.getDefenseDmg();
    }

}
