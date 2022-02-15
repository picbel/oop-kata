package com.study.oopkata.usecase;

import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import com.study.oopkata.domain.monster.Slime;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class FightSimulator {

    // 구현 액션 1번 캐릭터는 무기를 착용하여 몬스터에게 공격할수 있다.
    public void attackEnemy() throws Exception {
        Player player = new Player(new Human(1, new ShortSword()));
        Enemy enemy = new Enemy(new Slime(1));

        player.attack(enemy);

    }

    public void attackPlayer() throws Exception {
        Player player = new Player(new Human(1, new ShortSword()));
        Enemy enemy = new Enemy(new Slime(1));

        enemy.attack(player);

    }

}
