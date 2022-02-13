package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkillsTest {

    Characters characters;

    @BeforeEach
    void settingCharacter() throws Exception {
//        level,
//        1000*level, Hp
//        500*level,  Mp
//        100*level,  AttackDmg  * 1.2 (숏소드라 1.2배)
//        50*level,   Defense
//        1.0,        AttackSpeed
//        0.1,        evasionRate

        characters = new Human(1,new ShortSword());
    }

    @Test
    void isAvailableMp() {
        //given

        //when

        //then
    }

    @Test
    void heal() {
        //given

        //when

        //then
    }

    @Test
    void steam() {
        //given

        //when

        //then
    }

    @Test
    void endSteam() {
        //given

        //when

        //then
    }
}