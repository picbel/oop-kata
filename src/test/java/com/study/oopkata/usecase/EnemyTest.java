package com.study.oopkata.usecase;

import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import com.study.oopkata.domain.monster.Slime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

class EnemyTest {

    @DisplayName("슬라임 피격 테스트")
    @Test
    void beHit() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = spy(new Slime(1));

        Enemy enemy = new Enemy(slime);

        given(slime.isCounter())
                .willReturn(false);
        //when
        enemy.beHit(human.getAttackDmg());

        //then
        assertThat(slime.getHp()).isEqualTo(20);
        assertThat(human.getHp()).isEqualTo(1000);
    }



}