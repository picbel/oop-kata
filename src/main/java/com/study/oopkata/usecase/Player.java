package com.study.oopkata.usecase;

import com.study.oopkata.domain.Stat;
import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.util.RandomEvent;

public class Player implements Behavior{

    Characters characters; // 팩토리 메서드 예정

    RandomEvent randomEvent;

    public Player(Characters characters, RandomEvent randomEvent) {
        this.characters = characters;
        this.randomEvent = randomEvent;
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
        return randomEvent.randomEventResult(characters.getEvasionRate());
    }
}
