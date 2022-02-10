package com.study.oopkata.domain.character.weapon;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class Weapon {
    protected String name;

    double attackDmgIncreasePer;

    double attackSpeedIncreasePer;

    public int calculateAttackDmg(int attackDmg){
        return (int) (attackDmg*attackDmgIncreasePer);
    }

    public double calculateAttackSpeed(double attackSpeed){
        return (attackSpeed*attackSpeedIncreasePer);
    }


}
