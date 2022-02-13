package com.study.oopkata.domain.character.weapon.axe;

import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.Orc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AxeTest {

    @DisplayName("Orc Axe 장착 가능")
    @Test
    void mountTest() throws Exception {
        //given
        Orc orc = new Orc(1,null);
        IronAxe ironAxe = new IronAxe();
        //when
        boolean mountable = ironAxe.isMountable(orc);
        //then
        assertThat(mountable).isTrue();
    }

    @DisplayName("Human Axe 장착 불가")
    @Test
    void mountTest2() throws Exception {
        //given
        Human human = new Human(1,null);
        IronAxe ironAxe = new IronAxe();
        //when
        boolean mountable = ironAxe.isMountable(human);
        //then
        assertThat(mountable).isFalse();
    }
}