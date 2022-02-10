package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.weapon.axe.IronAxe;
import com.study.oopkata.domain.character.weapon.axe.ShortAxe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrcTest {
    @DisplayName("orc 캐릭터 생성 무기 미착용 상태")
    @Test
    void getOrcCharacter(){
        //given
        int level = 1;

        //when
        Orc orc = new Orc(level,null);

        //then
        assertThat(orc.getLevel()).isEqualTo(level);
        assertThat(orc.getHp()).isEqualTo(1200);
    }

    @DisplayName("orc 캐릭터 생성 무기는 Short Axe")
    @Test
    void getOrcCharacter_2(){
        //given
        int level = 1;

        //when
        Orc orc = new Orc(level,new ShortAxe());

        //then
        assertThat(orc.getLevel()).isEqualTo(level);
        assertThat(orc.getHp()).isEqualTo(1200);
        assertThat(orc.getWeapon().getName()).isEqualTo("Short Axe");
        assertThat(orc.getAttackDmg()).isEqualTo(132);
        assertThat(orc.getAttackSpeed()).isEqualTo(0.66);


    }

    @DisplayName("orc 캐릭터 생성 무기 변경 Short Axe -> Iron Axe")
    @Test
    void changeWeapon(){
        //given
        int level = 1;

        //when
        Orc orc = new Orc(level,new ShortAxe());
        orc.mountWeapon(new IronAxe());

        //then
        assertThat(orc.getWeapon().getName()).isEqualTo("Iron Axe");
        assertThat(orc.getAttackDmg()).isEqualTo(144);
        assertThat(orc.getAttackSpeed()).isEqualTo(0.63);

    }
}