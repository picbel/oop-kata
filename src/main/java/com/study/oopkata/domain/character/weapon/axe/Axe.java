package com.study.oopkata.domain.character.weapon.axe;

import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.domain.character.Orc;
import com.study.oopkata.domain.character.weapon.Weapon;

public abstract class Axe extends Weapon {
    protected Axe(String name, double attackDmgIncreasePer, double attackSpeedIncreasePer) {
        super(name, attackDmgIncreasePer, attackSpeedIncreasePer);
    }

    public boolean isMountable(Characters characters){
        return characters instanceof Orc;
    }
}
