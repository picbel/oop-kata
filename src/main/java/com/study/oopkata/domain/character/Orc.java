package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.skill.OrcSkills;
import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Orc extends Characters {

    public Orc(@NonNull Integer level, Weapon weapon) throws Exception {
        super("Orc",level, 1200*level, 300*level, 120*level, 30*level,0.7, 0, weapon, new OrcSkills());
    }

    @Override
    public void levelUp(int up) {
        plusLevel(up);
        plusHp(1200 * up);
        plusMp(300 * up);
        plusAttackDmg(120 * up);
        plusDefenseDmg(30*up);
    }
}
