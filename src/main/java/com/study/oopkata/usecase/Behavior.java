package com.study.oopkata.usecase;

import com.study.oopkata.domain.Stat;
import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.domain.monster.Monster;

public interface Behavior {

//    void attack();

    boolean attackDelay();

    void beHit(int attackerDamage);

    default int calculateDamage(int attackerDmage, Stat defender){
        return attackerDmage - defender.getDefenseDmg();
    }

    // 공격 회피 등 캐릭터와 몬스터를 조합하는 시스템은 Behavior 구현체에서 구현
    // 배틀 시뮬레이터는 두개를 반복실행하는 시뮬레이터의 역할
}
