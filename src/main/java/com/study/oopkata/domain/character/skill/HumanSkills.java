package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Human;

import java.time.LocalDateTime;

public class HumanSkills extends Skills{

    public void guard(Human characters) throws Exception {
        isAvailableMp(characters, 300);
        skillEndTimeMap.put("guard", LocalDateTime.now().plusSeconds(10));
        characters.multiplyDefenseDmgPer(1.3);
        characters.minusMp(300);
    }

    public void endGuard(Human characters) throws Exception{
        characters.divideDefenseDmgPer(1.3);
    }



}
