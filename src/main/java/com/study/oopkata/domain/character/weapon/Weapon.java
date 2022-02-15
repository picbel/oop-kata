package com.study.oopkata.domain.character.weapon;

import com.study.oopkata.domain.character.Characters;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Weapon {
    protected String name;

    double attackDmgIncreasePer;

    double attackSpeedIncreasePer;

    public abstract boolean isMountable(Characters characters);

    public String getName() {
        return name;
    }

    public int calculateAttackDmg(int attackDmg){
        return (int) (attackDmg*attackDmgIncreasePer);
    }

    public double calculateAttackSpeed(double attackSpeed){
        return (attackSpeed*attackSpeedIncreasePer);
    }

}
