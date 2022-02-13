package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.sword.ShortSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @DisplayName("스킬 사용 가능 마나 확인 테스트")
    @Test
    void isAvailableMp() throws Exception {
        //given
        HumanSkills skill = new HumanSkills();
        //when
        boolean availableMp = skill.isAvailableMp(human, 100);
        //then
        assertThat(availableMp).isTrue();
    }

    @DisplayName("스킬 사용 가능 마나 확인 테스트 결과 false")
    @Test
    void isAvailableMpFalse() throws Exception {
        //given
        HumanSkills skill = new HumanSkills();
        //when

        //then
        assertThatThrownBy(() -> skill.isAvailableMp(human, 10000)).hasMessage("사용할 마나가 부족합니다.");
    }

    @DisplayName("공용스킬 heal 테스트")
    @Test
    void heal() throws Exception{
        //given
        HumanSkills skill = new HumanSkills();
        //when
        skill.heal(human);
        //then
        assertThat(human.getHp()).isEqualTo(1500);
    }

    @DisplayName("공용스킬 steam 테스트")
    @Test
    void steam() throws Exception{
        //given
        HumanSkills skill = new HumanSkills();
        //when
        skill.steam(human);
        //then
        assertThat(human.getAttackDmg()).isEqualTo(126);
    }

    @DisplayName("공용스킬 steam 종료 테스트")
    @Test
    void endSteam() throws Exception{
        //given
        HumanSkills skill = new HumanSkills();
        //when
        skill.steam(human);
        skill.endSteam(human);
        //then
        assertThat(human.getAttackDmg()).isEqualTo(105);
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
        HumanSkills skill = new HumanSkills();
        Human human = new Human(100,new ShortSword());
        //when
        skill.ultimate(human);
        skill.endUltimate(human);
        //then
        assertThat(human.isHitStatus()).isFalse();
    }

    @DisplayName("궁극기 1level 사용 테스트 결과 실패")
    @Test
    void ultimate_false() throws Exception {
        //given
        HumanSkills skill = new HumanSkills();
        //when

        //then
        assertThatThrownBy(() -> skill.ultimate(human)).hasMessage("99 Level부터 궁극기를 사용 할 수 있습니다.");
    }

}