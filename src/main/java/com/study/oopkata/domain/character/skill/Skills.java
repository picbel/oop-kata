package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Characters;

import java.time.LocalDateTime;
import java.util.HashMap;

public abstract class Skills {

    protected HashMap<String, LocalDateTime> skillEndTimeMap = new HashMap<>();

    protected boolean isAvailableMp(Characters characters, int useMp) throws Exception {
        boolean available = 0 <= (characters.getMp() - useMp);
        if (!available){
            throw new Exception("사용할 마나가 부족합니다.");
        }
        return true;
    }

    public void heal(Characters characters) throws Exception {
        isAvailableMp(characters, 100);
        characters.plusHp(500);
        characters.minusMp(100);
    }

    public void steam(Characters characters) throws Exception {
        isAvailableMp(characters, 300);
        skillEndTimeMap.put("steam",LocalDateTime.now().plusSeconds(10));
        characters.multiplyAttackDmgPer(1.2);
        characters.minusMp(300);
    }

    public void endSteam(Characters characters) {
        characters.divideAttackDmgPer(1.2);
    }

//    abstract Characters ultimateSkill();



}
