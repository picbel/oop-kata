package com.study.oopkata.domain.character;


import com.study.oopkata.domain.character.skill.ElfSkills;
import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Elf extends Characters {

    public Elf(@NonNull Integer level, Weapon weapon) throws Exception{
        super("Elf",level, 750*level, 700*level, 50*level, 30*level,2, 0.25, weapon,new ElfSkills());

    }

    @Override
    public void levelUp(int up) {
        plusLevel(up);
        plusHp(750 * up);
        plusMp(700 * up);
        plusAttackDmg(50 * up);
        plusDefenseDmg(30*up);
    }
}
