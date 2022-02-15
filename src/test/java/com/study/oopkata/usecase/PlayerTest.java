package com.study.oopkata.usecase;

import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import com.study.oopkata.domain.monster.Slime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
class PlayerTest {

    @DisplayName("데미지 계산 테스트")
    @Test
    void calculateDamageTest() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = new Slime(1);

        //when
        Player player = new Player(human);
        int damage = player.calculateDamage(human.getAttackDmg(), slime);

        //then
        // 휴먼 attack / 슬라임 defense
        // 휴먼 공격력 105, 슬라임 방어력 25
        assertThat(damage).isEqualTo(80); // 슬라임이 입는 데미지
    }

    @DisplayName("플레이어 피격 테스트")
    @Test
    void beHit() throws Exception {
        //given
        Human human = new Human(1, new ShortSword());
        Slime slime = new Slime(1);

        Player player = spy(new Player(human));

        given(player.isAttackMiss())
                .willReturn(false);

        //when
        player.beHit(slime.getAttackDmg());

        //then
        assertThat(human.getHp()).isEqualTo(750);

    }

    @DisplayName("플레이어 몬스터 공격시 반격 테스트")
    @Test
    void attack() throws Exception {
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
        player.attack(enemy);

        //then
        assertThat(slime.getHp()).isEqualTo(20);
        assertThat(human.getHp()).isEqualTo(840);

    }

}