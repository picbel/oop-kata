package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.domain.character.Elf;

import java.time.LocalDateTime;

public class ElfSkills extends Skills{

    public void elusion(Elf characters) throws Exception {
        isAvailableMp(characters, 300);
        skillEndTimeMap.put("elusion", LocalDateTime.now().plusSeconds(10));
        characters.multiplyEvasionRate(1.3);
        characters.minusMp(300);
    }

    public void endElusion(Elf characters) throws Exception{
        isEndSkill("elusion");
        characters.divideEvasionRate(1.3);
    }

    @Override
    public void ultimate(Characters characters) throws Exception {
        if (!characters.isUsedUltimate()){throw new Exception("99 Level부터 궁극기를 사용 할 수 있습니다.");}
        isAvailableMp(characters, 3000);
        rapid(characters);
        characters.minusMp(3000);
    }

    @Override
    public void endUltimate(Characters characters) throws Exception {
        endRapid(characters);
    }

    public void rapid(Characters characters) throws Exception {
        skillEndTimeMap.put("rapid", LocalDateTime.now().plusMinutes(1));
        characters.multiplyAttackSpeed(5);
    }

    public void endRapid(Characters characters) throws Exception {
        isEndSkill("rapid");
        characters.divideAttackSpeed(5);
    }
}
