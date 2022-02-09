package com.study.oopkata.character.domain;


import com.study.oopkata.character.model.Weapon;
import lombok.Builder;
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
//    protected Skill skill;

    protected Weapon weapon;


    @Builder
    protected Character(int level, int hp, int mp, int attackDmg, double attackSpeed, int defenseDmg, double evasionRate, Weapon weapon) {
        this.level = level;
        this.hp = hp;
        this.mp = mp;
        this.attackDmg = attackDmg;
        this.attackSpeed = attackSpeed;
        this.defenseDmg = defenseDmg;
        this.evasionRate = evasionRate;
        weapon.mount(this);
    }

    public void changeProperty(){

    }



}
