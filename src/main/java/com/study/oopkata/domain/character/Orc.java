package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Orc extends Character<Orc>{


    public Orc(int hp, int mp, int attackDmg, int defenseDmg, int level, double attackSpeed, double evasionRate, Weapon weapon) {
        super(hp, mp, attackDmg, defenseDmg, level, attackSpeed, evasionRate, weapon);
    }

    @Override
    public Orc useSkill() {
        return null;
    }

    @Override
    protected Orc getThis() {
        return this;
    }
}
