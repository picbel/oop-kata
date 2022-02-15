package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.weapon.sword.LongSword;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HumanTest {
    @DisplayName("human 캐릭터 생성 무기 미착용 상태")
    @Test
    void getHumanCharacter() throws Exception {
        //given
        int level = 1;

        //when
        Human human = new Human(level,null);

        //then
        assertThat(human.getLevel()).isEqualTo(level);
        assertThat(human.getHp()).isEqualTo(1000);
    }

    @DisplayName("human 캐릭터 생성 무기는 short sword")
    @Test
    void getHumanCharacter_2() throws Exception{
        //given
        int level = 1;

        //when
        Human human = new Human(level,new ShortSword());

        //then
        assertThat(human.getLevel()).isEqualTo(level);
        assertThat(human.getHp()).isEqualTo(1000);
        assertThat(human.getWeapon().getName()).isEqualTo("Short Sword");
        assertThat(human.getAttackDmg()).isEqualTo(105);

    }

    @DisplayName("human 캐릭터 생성 무기 변경 Short Sword -> Long Sword")
    @Test
    void changeWeapon() throws Exception {
        //given
        int level = 1;

        //when
        Human human = new Human(level,new ShortSword());
        human.mountWeapon(new LongSword());

        //then
        assertThat(human.getWeapon().getName()).isEqualTo("Long Sword");
        assertThat(human.getAttackDmg()).isEqualTo(110);

    }

    @DisplayName("Human 캐릭터 레벨업")
    @Test
    void levelUp() throws Exception {
        //given
        int level = 1;
        Human human = new Human(level,new ShortSword());
        //when
        human.levelUp(1);
        //then
        assertThat(human.getLevel()).isEqualTo(2);
        assertThat(human.getHp()).isEqualTo(2000);
        assertThat(human.getAttackDmg()).isEqualTo(210);
    }
}