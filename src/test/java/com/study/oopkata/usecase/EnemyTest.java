package com.study.oopkata.usecase;

import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import com.study.oopkata.domain.monster.Slime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
class EnemyTest {

    @DisplayName("슬라임 피격 테스트")
    @Test
    void beHit() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = spy(new Slime(1));

        Enemy enemy = new Enemy(slime);

        //when
        enemy.beHit(human.getAttackDmg());

        //then
        assertThat(slime.getHp()).isEqualTo(20);
        assertThat(human.getHp()).isEqualTo(1000);
    }

    @DisplayName("몬스터 공격 테스트")
    @Test
    void attack() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = new Slime(1);

        Player player =  spy(new Player(human));
        Enemy enemy = new Enemy(slime);

        given(player.isAttackMiss())
                .willReturn(false);

        //when
        enemy.attackPlayer(player);

        //then
        assertThat(human.getHp()).isEqualTo(750);

    }

    @DisplayName("몬스터 카운터 공격 테스트")
    @Test
    void attack_2() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = new Slime(1);

        Player player =  spy(new Player(human));
        Enemy enemy = new Enemy(slime);

        given(player.isAttackMiss())
                .willReturn(false);

        //when
        enemy.counterAttackPlayer(player);

        //then
        assertThat(human.getHp()).isEqualTo(840);

    }

    @DisplayName("몬스터 카운터 공격 플레이어 사망 테스트")
    @Test
    void attack_3() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = new Slime(100);

        Player player =  spy(new Player(human));
        Enemy enemy = new Enemy(slime);

        given(player.isAttackMiss())
                .willReturn(false);

        //when

        //then
        assertThatThrownBy(() ->  enemy.counterAttackPlayer(player)).hasMessage("플레이어가 사망하였습니다.");
        assertThat(human.isDie()).isTrue();

    }


}