package com.study.oopkata.domain.character.skill;

import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.domain.character.Human;

import java.time.LocalDateTime;

public class HumanSkills extends Skills{

    public void guard(Human characters) throws Exception {
        isAvailableMp(characters, 300);
        skillEndTimeMap.put("guard", LocalDateTime.now().plusSeconds(10));
        characters.multiplyDefenseDmg(1.3);
        characters.minusMp(300);
    }

    public void endGuard(Human characters) throws Exception{
        characters.divideDefenseDmg(1.3);
    }

    @Override
    public void ultimate(Characters characters) throws Exception {
        if (!characters.isUsedUltimate()){throw new Exception("99 Level부터 궁극기를 사용 할 수 있습니다.");}
        isAvailableMp(characters, 3000);
        invincible(characters);
        characters.minusMp(3000);
    }

    @Override
    public void endUltimate(Characters characters) throws Exception {
        endInvincible(characters);
    }

    public void invincible(Characters characters){
        skillEndTimeMap.put("invincible", LocalDateTime.now().plusSeconds(10));
        characters.changeHitStatus(true);
    }
    public void endInvincible(Characters characters) throws Exception {
        characters.changeHitStatus(false);
    }
}
