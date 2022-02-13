package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.skill.OrcSkills;
import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Orc extends Characters<Orc> {

    public Orc(@NonNull int level, Weapon weapon) throws Exception {
        super( level, 1200*level, 300*level, 120*level, 30*level,0.7, 0, weapon, new OrcSkills());
    }

    @Override
    public Orc useSkill() {
        return null;
    }

}
