package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
class HumanSkillsTest {
    Human human;

    @BeforeEach
    void settingCharacter() throws Exception {
//        level,
//        1000*level, Hp
//        500*level,  Mp
//        100*level,  AttackDmg  * 1.05 (숏소드라 1.2배)
//        50*level,   Defense
//        1.0,        AttackSpeed
//        0.1,        evasionRate
        human = new Human(1,new ShortSword());

        assertThat(human.getSkill() instanceof HumanSkills).isTrue();
    }

    @DisplayName("human 스킬 guard 테스트")
    @Test
    void guard() throws Exception {
        //given
        HumanSkills skill = new HumanSkills();
        //when
        skill.guard(human);
        //then
        assertThat(human.getDefenseDmg()).isEqualTo(65);
    }

    @DisplayName("human 스킬 guard 종료 테스트")
    @Test
    void endGuard() throws Exception {
        //given
        HumanSkills skill = new HumanSkills();
        //when
        skill.guard(human);
        skill.endGuard(human);
        //then
        assertThat(human.getDefenseDmg()).isEqualTo(50);
    }

    @DisplayName("human 스킬 궁극기 사용 테스트")
    @Test
    void ultimate() throws Exception {
        //given
        HumanSkills skill = new HumanSkills();
        Human human = new Human(100,new ShortSword());
        //when
        skill.ultimate(human);
        //then
        assertThat(human.isHitStatus()).isTrue();
    }

    @DisplayName("human 스킬 궁극기 종료 테스트")
    @Test
    void ultimate_2() throws Exception {
        //given
        Human human = new Human(100,new ShortSword());
        HumanSkills skill = spy(HumanSkills.class);

        skill.ultimate(human);
        given(skill.isEndSkill("invincible"))
                .willReturn(true);

        //when
        boolean endSkill = skill.isEndSkill("invincible");
        skill.endUltimate(human);

        //then
        assertThat(endSkill).isTrue();
        assertThat(human.isHitStatus()).isFalse();
    }

}