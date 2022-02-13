package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Elf;

import java.time.LocalDateTime;

public class ElfSkills extends Skills{

    public void elusion(Elf characters) throws Exception {
        isAvailableMp(characters, 300);
        skillEndTimeMap.put("elusion", LocalDateTime.now().plusSeconds(10));
        characters.multiplyEvasionRate(1.3);
    }

    public void endElusion(Elf characters) throws Exception{
        characters.divideEvasionRate(1.3);
    }
}
