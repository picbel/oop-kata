package com.study.oopkata.usecase;

import com.study.oopkata.domain.Stat;
import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.util.RandomEventUtil;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Log4j2
public class Player implements Behavior{

    Characters characters;

    private final Deque<LocalDateTime> attackLog = new ArrayDeque<>();

    public Characters getCharacters() {
        return characters;
    }

    public Player(Characters characters) {
        this.characters = characters;
    }

    @Override
    public void beHit(int attackerDamage){
        if (!isAttackMiss()){
            log.info("===== 플레이어가 {}의 피해를 입었습니다. =====",calculateDamage(attackerDamage, characters));
            characters.minusHp(calculateDamage(attackerDamage, characters));
        }else {
            log.info("===== 공격을 회피하였습니다. =====");
        }
    }

    private LocalDateTime calculateNextAttackTime(Characters characters){
        double nextAttackTime = 1 * characters.getAttackSpeed(); // 1초에 공격 하는 수
        int second = (int) nextAttackTime;
        int nanoSecond = (int) ((nextAttackTime-second) * 1000000000);
        LocalDateTime dateTime = attackLog.peekLast();
        if (Objects.nonNull(dateTime)) {
            return dateTime.plusSeconds(second).plusNanos(nanoSecond);
        }else {
            return LocalDateTime.now();
        }
    }

    public boolean isAttack() {
        if (attackLog.isEmpty()){return true;}
        LocalDateTime nextAttackTime = calculateNextAttackTime(characters);
        return LocalDateTime.now().isAfter(nextAttackTime);
    }

    public void attackEnemy(Enemy enemy) throws Exception {
        if(isAttack()){
            log.info("===== 플레이어가 몬스터({})를 공격 하였습니다. =====",enemy.getMonster().getRace());
            attackLog.offerLast(LocalDateTime.now());
            enemy.beHit(characters.getAttackDmg());
            if (enemy.getMonster().isCounter()){
                log.info("===== 몬스터({})가 반격하였습니다. =====",enemy.getMonster().getRace());
                enemy.counterAttackPlayer(this);
            }
            if (enemy.getMonster().isDie()){
                characters.levelUp(1);
                log.info("===== LEVEL UP  플레이어 level = {} =====",characters.getLevel());
            }
        }else {
            log.info("===== 공격 대기시간 입니다. 딜레이 종료 시간 {} =====",attackLog.peekLast());
        }
    }

    public boolean isAttackMiss() {
        return RandomEventUtil.randomEventResult(characters.getEvasionRate());
    }
}
