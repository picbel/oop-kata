package com.study.oopkata.character.domain;

import com.study.oopkata.character.model.Weapon;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Elf extends Character{


    protected Elf(int level, int hp, int mp, int attackDmg, double attackSpeed, int defenseDmg, double evasionRate, Weapon weapon) {
        super(level, hp, mp, attackDmg, attackSpeed, defenseDmg, evasionRate, weapon);
    }
}
