package com.study.oopkata.usecase;

import com.study.oopkata.domain.Stat;

public interface Behavior {

//    void attack();

    boolean attackDelay();

    boolean beHit(Stat attacker);

    default int calculateDamage(Stat attacker, Stat defender){
        return attacker.getAttackDmg() - defender.getDefenseDmg();
    }

    // 공격 회피 등 캐릭터와 몬스터를 조합하는 시스템은 Behavior 구현체에서 구현
    // 배틀 시뮬레이터는 두개를 반복실행하는 시뮬레이터의 역할
}
