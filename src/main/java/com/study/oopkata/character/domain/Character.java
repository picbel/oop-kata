package com.study.oopkata.character.domain;

import com.study.oopkata.weapon.domain.Weapon;
import lombok.Getter;

@Getter
public abstract class Character {
    protected int level;
    protected int hp;
    protected int mp;
    protected int attackDmg;
    protected double attackSpeed;
    protected int defenseDmg;
    protected double evasionRate;

    protected Weapon weapon;

    public void heal(){
        hp+=100;
    }

    public void steam(){
        attackDmg*= 0.2;
    }




}
