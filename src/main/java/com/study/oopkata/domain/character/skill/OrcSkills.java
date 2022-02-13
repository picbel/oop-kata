package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Orc;

import java.time.LocalDateTime;

public class OrcSkills extends Skills{
    public void anger(Orc characters) throws Exception {
        isAvailableMp(characters, 300);
        skillEndTimeMap.put("anger", LocalDateTime.now().plusSeconds(10));
        characters.multiplyAttackDmgPer(1.5);
        characters.multiplyDefenseDmgPer(1 - 0.1);
    }

    public void endAnger(Orc characters) throws Exception{
        characters.divideAttackDmgPer(1.5);
        characters.divideDefenseDmgPer(1 - 0.1);
    }
}
