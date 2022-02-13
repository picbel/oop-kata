package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Elf;
import com.study.oopkata.domain.character.weapon.bow.ShortBow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ElfSkillsTest {
    Elf elf;

    @BeforeEach
    void settingCharacter() throws Exception {
//       level,
//       750*level, 700*level, 50*level, 30*level,2, 0.25, weapon,new ElfSkills()
        elf = new Elf(1,new ShortBow());

        assertThat(elf.getSkill() instanceof ElfSkills).isTrue();
    }

    @DisplayName("Elf 스킬 elusion 테스트")
    @Test
    void elusion() throws Exception {
        //given
        ElfSkills skill = new ElfSkills();
        //when
        skill.elusion(elf);
        //then
        assertThat(elf.getEvasionRate()).isEqualTo(0.33);
    }

    @DisplayName("Elf 스킬 elusion 종료 테스트")
    @Test
    void endElusion() throws Exception {
        //given
        ElfSkills skill = new ElfSkills();
        //when
        skill.elusion(elf);
        skill.endElusion(elf);
        //then
        assertThat(elf.getEvasionRate()).isEqualTo(0.25);
    }

    @DisplayName("Elf 스킬 궁극기 사용 테스트")
    @Test
    void ultimate() throws Exception {
        //given
        ElfSkills skill = new ElfSkills();
        elf = new Elf(100,new ShortBow());
        //when
        skill.ultimate(elf);
        //then
        assertThat(elf.getAttackSpeed()).isEqualTo(10.5);
    }

}