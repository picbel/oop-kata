package com.study.oopkata.usecase;

import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.util.RandomEventUtil;

public class Player implements Behavior{

    Characters characters; // 팩토리 메서드 예정

    public Characters getCharacters() {
        return characters;
    }

    public Player(Characters characters) {
        this.characters = characters;
    }

    @Override
    public void beHit(int attackerDamage) {
        if (!isAttackMiss()){
            characters.minusHp(calculateDamage(attackerDamage, characters));
        }
    }

    public void attack(Enemy enemy){
        enemy.beHit(characters.getAttackDmg());
        if (enemy.getMonster().isCounter()){
            this.beHit(enemy.getMonster().getCountAttackDamage());
        }
    }

    public boolean isAttackMiss() {
        return RandomEventUtil.randomEventResult(characters.getEvasionRate());
    }
}
