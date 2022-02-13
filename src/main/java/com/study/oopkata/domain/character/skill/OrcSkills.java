package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.domain.character.Orc;

import java.time.LocalDateTime;

public class OrcSkills extends Skills{
    public void anger(Orc characters) throws Exception {
        isAvailableMp(characters, 300);
        skillEndTimeMap.put("anger", LocalDateTime.now().plusSeconds(10));
        characters.multiplyAttackDmg(1.5);
        characters.multiplyDefenseDmg(1 - 0.1);
        characters.minusMp(300);
    }

    public void endAnger(Orc characters) throws Exception{
        characters.divideAttackDmg(1.5);
        characters.divideDefenseDmg(1 - 0.1);
    }

    @Override
    public void ultimate(Characters characters) throws Exception {
        if (!characters.isUsedUltimate()){throw new Exception("99 Level부터 궁극기를 사용 할 수 있습니다.");}
        isAvailableMp(characters, 3000);
        frenzy(characters);
        characters.minusMp(3000);
    }

    @Override
    public void endUltimate(Characters characters) throws Exception {
        endFrenzy(characters);
    }

    public void frenzy(Characters characters) throws Exception {
        skillEndTimeMap.put("frenzy", LocalDateTime.now().plusMinutes(1));
        characters.multiplyAttackDmg(5);
    }

    public void endFrenzy(Characters characters) throws Exception {
        characters.divideAttackDmg(5);
    }
}
