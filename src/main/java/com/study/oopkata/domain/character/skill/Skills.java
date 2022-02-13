package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Characters;

import java.time.LocalDateTime;
import java.util.HashMap;

public abstract class Skills {

    protected HashMap<String, LocalDateTime> skillEndTimeMap = new HashMap<>();

    public abstract void ultimate(Characters characters) throws Exception;

    public abstract void endUltimate(Characters characters) throws Exception;

    protected boolean isAvailableMp(Characters characters, int useMp) throws Exception {
        boolean available = 0 <= (characters.getMp() - useMp);
        if (!available){
            throw new Exception("사용할 마나가 부족합니다.");
        }
        return true;
    }

    protected boolean isEndSkill(String skillName) throws Exception {
        return isEndSkill(skillName,LocalDateTime.now());
    }

    protected boolean isEndSkill(String skillName,LocalDateTime now) throws Exception {
        if (!skillEndTimeMap.containsKey(skillName)){throw new Exception("사용한적 없는 스킬입니다.");}

        boolean after = now.isAfter(skillEndTimeMap.get(skillName));
        if (after){deleteSkillEndTime(skillName);}
        return after;
    }

    protected void deleteSkillEndTime(String skillName){
        skillEndTimeMap.remove(skillName);
    }

    public void heal(Characters characters) throws Exception {
        isAvailableMp(characters, 100);
        characters.plusHp(500);
        characters.minusMp(100);
    }

    public void steam(Characters characters) throws Exception {
        isAvailableMp(characters, 300);
        skillEndTimeMap.put("steam",LocalDateTime.now().plusSeconds(10));
        characters.multiplyAttackDmg(1.2);
        characters.minusMp(300);
    }
    public void endSteam(Characters characters) throws Exception {
        characters.divideAttackDmg(1.2);
    }

}
