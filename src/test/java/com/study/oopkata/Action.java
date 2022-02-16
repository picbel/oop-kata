package com.study.oopkata;

import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import com.study.oopkata.domain.monster.Slime;
import com.study.oopkata.usecase.Enemy;
import com.study.oopkata.usecase.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

class Action {

    // 캐릭터는 무기를 착용하여 몬스터에게 공격 할 수 있다.
    // 캐릭터는 공격 후에는 공격속도에 따라 딜레이가 발생한다.
    @DisplayName("Action 플레이어 몬스터 공격, 공격 딜레이 확인")
    @Test
    void action1() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = spy(new Slime(1));

        Player player =  spy(new Player(human));
        Enemy enemy = new Enemy(slime);

        given(slime.isCounter())
                .willReturn(false);

        //when
        player.attackEnemy(enemy);
        player.attackEnemy(enemy);

        //then
        assertThat(slime.getHp()).isEqualTo(20);
        assertThat(human.getHp()).isEqualTo(1000);
    }

    // 캐릭터는 본인이 습득한 스킬을 사용할 수 있다.
    // 스킬클래스는 캐릭터 클래스가 생성될때 같이 생성되어 조립됩니다. 다른캐릭터의 스킬을 생성할수 없습니다.


    // 몬스터 또한 캐릭터를 공격할 수 있다.
    @DisplayName("Action 플레이어 몬스터 공격시 반격")
    @Test
    void action2() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = spy(new Slime(1));

        Player player =  spy(new Player(human));
        Enemy enemy = new Enemy(slime);

        given(slime.isCounter())
                .willReturn(true);

        given(player.isAttackMiss())
                .willReturn(false);

        //when
        player.attackEnemy(enemy);

        //then
        assertThat(slime.getHp()).isEqualTo(20);
        assertThat(human.getHp()).isEqualTo(840);

    }

    // 공격 또는 반격시(몬스터) 대상의 회피율에 따라 무시될 수 있다
    @DisplayName("Action 플레이어 몬스터 반격 회피")
    @Test
    void action3() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = spy(new Slime(1));

        Player player =  spy(new Player(human));
        Enemy enemy = new Enemy(slime);

        given(slime.isCounter())
                .willReturn(true);

        given(player.isAttackMiss())
                .willReturn(true);

        //when
        player.attackEnemy(enemy);

        //then
        assertThat(slime.getHp()).isEqualTo(20);
        assertThat(human.getHp()).isEqualTo(1000);

    }

}
