package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.skill.HumanSkills;
import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Human extends Characters {

    public Human(@NonNull Integer level, Weapon weapon) throws Exception {
        super("Human",level, 1000*level, 500*level, 100*level, 50*level,1.0, 0.1, weapon, new HumanSkills());
    }

    @Override
    public void levelUp(int up) {
        plusLevel(up);
        plusHp(1000 * up);
        plusMp(500 * up);
        plusAttackDmg(100 * up);
        plusDefenseDmg(50*up);
    }
}
