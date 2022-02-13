package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.skill.HumanSkills;
import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Human extends Characters {

    public Human(@NonNull int level, Weapon weapon) throws Exception {
        super(level, 1000*level, 500*level, 100*level, 50*level,1.0, 0.1, weapon, new HumanSkills());
    }
}
