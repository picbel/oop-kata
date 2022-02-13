package com.study.oopkata.domain.character.weapon;

import com.study.oopkata.domain.character.Characters;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class Weapon {
    protected String name;

    double attackDmgIncreasePer;

    double attackSpeedIncreasePer;

    public abstract boolean isMountable(Characters characters);

    public int calculateAttackDmg(int attackDmg){
        return (int) (attackDmg*attackDmgIncreasePer);
    }

    public double calculateAttackSpeed(double attackSpeed){
        return (attackSpeed*attackSpeedIncreasePer);
    }

}
