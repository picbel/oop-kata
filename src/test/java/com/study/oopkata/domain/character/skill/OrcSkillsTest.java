package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Orc;
import com.study.oopkata.domain.character.weapon.axe.ShortAxe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrcSkillsTest {
    Orc orc;

    @BeforeEach
    void settingCharacter() throws Exception {
//        level, 1200*level, 300*level, 120*level, 30*level,0.7, 0, weapon, new OrcSkills()
        orc = new Orc(1,new ShortAxe());

        assertThat(orc.getSkill() instanceof OrcSkills).isTrue();
    }

    @DisplayName("Orc 스킬 anger 테스트")
    @Test
    void anger() throws Exception {
        //given
        OrcSkills skill = new OrcSkills();
        //when
        skill.anger(orc);
        //then
        assertThat(orc.getAttackDmg()).isEqualTo(198);
        assertThat(orc.getDefenseDmg()).isEqualTo(27);

    }

    @DisplayName("Orc 스킬 anger 종료 테스트")
    @Test
    void endAnger() throws Exception {
        //given
        OrcSkills skill = new OrcSkills();
        //when
        skill.anger(orc);
        skill.endAnger(orc);
        //then
        assertThat(orc.getAttackDmg()).isEqualTo(132);
        assertThat(orc.getDefenseDmg()).isEqualTo(30);
    }

}