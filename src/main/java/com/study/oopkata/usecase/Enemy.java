package com.study.oopkata.usecase;

import com.study.oopkata.domain.monster.Monster;


public class Enemy implements Behavior{

    Monster monster;

    public Monster getMonster() {
        return monster;
    }

    public Enemy(Monster monster) {
        this.monster = monster;
    }

    @Override
    public boolean attackDelay() {
        return false;
    }

    @Override
    public void beHit(int attackerDamage) {
        monster.minusHp(calculateDamage(attackerDamage, monster));
    }

    public void attack(Player player){
        player.beHit(monster.getAttackDmg());
    }


}
