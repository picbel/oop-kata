package com.study.oopkata.usecase;

import com.study.oopkata.domain.monster.Monster;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class Enemy implements Behavior{

    Monster monster;

    public Monster getMonster() {
        return monster;
    }

    public Enemy(Monster monster) {
        this.monster = monster;
    }

    @Override
    public void beHit(int attackerDamage) {
        log.info("===== 몬스터({})가 {}의 피해를 입었습니다. =====",monster.getRace(),calculateDamage(attackerDamage, monster));
        monster.minusHp(calculateDamage(attackerDamage, monster));
    }

    public void attackPlayer(Player player) throws Exception {
        log.info("===== 몬스터({})가 플레이어를 공격하였습니다.. =====",monster.getRace());
        player.beHit(monster.getAttackDmg());
        if (player.getCharacters().isDie()){
            log.info("===== 플레이어가 사망하였습니다. =====");
            throw new Exception("플레이어가 사망하였습니다.");
        }
    }


    public void counterAttackPlayer(Player player) throws Exception {
        player.beHit(monster.getCountAttackDamage());
        if (player.getCharacters().isDie()){
            log.info("===== 플레이어가 사망하였습니다. =====");
            throw new Exception("플레이어가 사망하였습니다.");
        }
    }
}
