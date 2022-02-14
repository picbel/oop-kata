package com.study.oopkata.usecase;

import com.study.oopkata.domain.Stat;
import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.util.RandomEventUtil;

public class Player implements Behavior{

    Characters characters; // 팩토리 메서드 예정

    public Player(Characters characters) {
        this.characters = characters;
    }

    @Override
    public boolean attackDelay() {
        return false;
    }

    @Override
    public boolean defend(Stat attacker) {
        if (isAttackMiss()){
            return true;
        }else{
            characters.minusHp(calculateDamage(attacker, characters));
            return false;
        }
    }

    @Override
    public boolean isAttackMiss() {
        return RandomEventUtil.randomEventResult(characters.getEvasionRate());
    }
}
