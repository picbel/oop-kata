package com.study.oopkata.domain.character;


import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Elf extends Character<Elf>{


    public Elf(int hp, int mp, int attackDmg, int defenseDmg, int level, double attackSpeed, double evasionRate, Weapon weapon) {
        super(hp, mp, attackDmg, defenseDmg, level, attackSpeed, evasionRate, weapon);
    }

    @Override
    public Elf useSkill() {
        return null;
    }

    @Override
    protected Elf getThis() {
        return this;
    }
}
