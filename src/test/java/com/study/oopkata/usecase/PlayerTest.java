package com.study.oopkata.usecase;

import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import com.study.oopkata.domain.monster.Slime;
import com.study.oopkata.util.RandomEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PlayerTest {

    @DisplayName("데미지 계산 테스트")
    @Test
    void calculateDamageTest() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = new Slime(1);

        //when
        Player player = new Player(human, new RandomEvent());
        int damage = player.calculateDamage(human, slime);

        //then
        // 휴먼 공격력 105, 슬라임 방어력 25
        assertThat(damage).isEqualTo(80);
    }

    @Test
    void defend(@Mock RandomEvent randomEvent) throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = new Slime(1);

        given(randomEvent.randomEventResult(anyDouble()))
                .willReturn(false);


        //when

        Player player = new Player(human, randomEvent);
        boolean defend = player.defend(slime);

        //then
        assertThat(defend).isFalse();
        assertThat(human.getHp()).isEqualTo(750);

    }

}