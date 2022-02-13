package com.study.oopkata.domain.character.weapon.bow;

import com.study.oopkata.domain.character.Elf;
import com.study.oopkata.domain.character.Human;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BowTest {
    @DisplayName("Elf Bow 장착 가능")
    @Test
    void mountTest() throws Exception {
        //given
        Elf elf = new Elf(1,null);
        ShortBow weapon = new ShortBow();
        //when
        boolean mountable = weapon.isMountable(elf);
        //then
        assertThat(mountable).isTrue();
    }

    @DisplayName("Human Bow 장착 불가")
    @Test
    void mountTest2() throws Exception {
        //given
        Human human = new Human(1,null);
        ShortBow weapon = new ShortBow();
        //when
        boolean mountable = weapon.isMountable(human);
        //then
        assertThat(mountable).isFalse();
    }

}