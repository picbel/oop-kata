package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.weapon.bow.IronBow;
import com.study.oopkata.domain.character.weapon.bow.ShortBow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ElfTest {
    @DisplayName("elf 캐릭터 생성 무기 미착용 상태")
    @Test
    void getElfCharacter() throws Exception{
        //given
        int level = 1;

        //when
        Elf elf = new Elf(level,null);

        //then
        assertThat(elf.getLevel()).isEqualTo(level);
        assertThat(elf.getHp()).isEqualTo(750);
    }

    @DisplayName("elf 캐릭터 생성 무기는 short Bow")
    @Test
    void getElfCharacter_2() throws Exception{
        //given
        int level = 1;

        //when
        Elf elf = new Elf(level,new ShortBow());

        //then
        assertThat(elf.getLevel()).isEqualTo(level);
        assertThat(elf.getHp()).isEqualTo(750);
        assertThat(elf.getWeapon().getName()).isEqualTo("Short Bow");
        assertThat(elf.getAttackSpeed()).isEqualTo(2.1);

    }

    @DisplayName("elf 캐릭터 생성 무기 변경 Short Bow -> Iron Bow")
    @Test
    void changeWeapon() throws Exception {
        //given
        int level = 1;

        //when
        Elf elf = new Elf(level,new ShortBow());
        elf.mountWeapon(new IronBow());

        //then
        assertThat(elf.getWeapon().getName()).isEqualTo("Iron Bow");
        assertThat(elf.getAttackSpeed()).isEqualTo(2.2);

    }

    @DisplayName("elf 캐릭터 레벨업")
    @Test
    void levelUp() throws Exception {
        //given
        int level = 1;
        Elf elf = new Elf(level,new ShortBow());
        //when
        elf.levelUp(1);
        //then
        assertThat(elf.getLevel()).isEqualTo(2);
        assertThat(elf.getHp()).isEqualTo(1500);
        assertThat(elf.getAttackDmg()).isEqualTo(100);
    }

    @DisplayName("elf 캐릭터 2 레벨업")
    @Test
    void levelUp_2() throws Exception {
        //given
        int level = 1;
        Elf elf = new Elf(level,new ShortBow());
        //when
        elf.levelUp(2);
        //then
        assertThat(elf.getLevel()).isEqualTo(3);
        assertThat(elf.getHp()).isEqualTo(2250);
        assertThat(elf.getAttackDmg()).isEqualTo(150);
    }

}