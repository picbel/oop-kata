package com.study.oopkata.domain.character.weapon.sword;

import com.study.oopkata.domain.character.Characters;
import com.study.oopkata.domain.character.Human;
import com.study.oopkata.domain.character.weapon.Weapon;

public class Sword extends Weapon {
    protected Sword(String name, double attackDmgIncreasePer, double attackSpeedIncreasePer) {
        super(name, attackDmgIncreasePer, attackSpeedIncreasePer);
    }

    public boolean isMountable(Characters characters){
        return characters instanceof Human;
    }

}
