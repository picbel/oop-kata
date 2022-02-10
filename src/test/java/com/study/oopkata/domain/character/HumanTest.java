package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.weapon.LongSword;
import com.study.oopkata.domain.character.weapon.ShortSword;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    @DisplayName("휴먼 캐릭터 생성 무기 미착용 상태")
    @Test
    void getHumanCharacter(){
        //given
        int level = 1;

        //when
        Human human = new Human(level,null);

        //then
        assertThat(human.getLevel()).isEqualTo(level);
        assertThat(human.getHp()).isEqualTo(1000);
    }

    @DisplayName("휴먼 캐릭터 생성 무기는 short sword")
    @Test
    void getHumanCharacter_2(){
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

    @DisplayName("휴먼 캐릭터 생성 무기 변경 Short Sword -> Long Sword")
    @Test
    void changeWeapon(){
        //given
        int level = 1;

        //when
        Human human = new Human(level,new ShortSword());
        human.mountWeapon(new LongSword());

        //then
        assertThat(human.getWeapon().getName()).isEqualTo("Long Sword");
        assertThat(human.getAttackDmg()).isEqualTo(110);

    }
}