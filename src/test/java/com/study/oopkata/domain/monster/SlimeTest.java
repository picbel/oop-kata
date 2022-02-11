package com.study.oopkata.domain.monster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SlimeTest {
    @DisplayName("1 level 슬라임 생성")
    @Test
    void slimeCreate() throws Exception{

        //given

        //when
        Slime slime = new Slime();
        //then
        assertThat(slime.getLevel()).isEqualTo(1);
        assertThat(slime.getAttackDmg()).isEqualTo(300);

    }

    @DisplayName("3 level 슬라임 생성")
    @Test
    void slimeCreate_level_3() throws Exception{

        //given

        //when
        Slime slime = new Slime(3);
        //then
        assertThat(slime.getLevel()).isEqualTo(3);
        assertThat(slime.getAttackDmg()).isEqualTo(900);


    }


}