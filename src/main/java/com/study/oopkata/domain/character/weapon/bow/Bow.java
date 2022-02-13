package com.study.oopkata.domain.character.weapon.bow;

import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.domain.character.Elf;
import com.study.oopkata.domain.character.weapon.Weapon;

public class Bow extends Weapon {
    protected Bow(String name, double attackDmgIncreasePer, double attackSpeedIncreasePer) {
        super(name, attackDmgIncreasePer, attackSpeedIncreasePer);
    }

    public boolean isMountable(Characters characters){
        return characters instanceof Elf;
    }

}
