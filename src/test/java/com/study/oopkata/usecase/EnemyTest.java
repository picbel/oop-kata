package com.study.oopkata.usecase;

import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import com.study.oopkata.domain.monster.Slime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.spy;

class EnemyTest {

    @DisplayName("슬라임 피격 테스트")
    @Test
    void defend() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = new Slime(1);

        Enemy enemy = spy(new Enemy(slime));

        //when

        boolean defend = enemy.beHit(human);

        //then
        assertThat(defend).isFalse();
        assertThat(slime.getHp()).isEqualTo(20);

    }

}