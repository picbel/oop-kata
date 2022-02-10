package com.study.oopkata.domain.character;


import com.study.oopkata.domain.Stat;
import com.study.oopkata.domain.character.weapon.Hand;
import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;

import java.text.DecimalFormat;
import java.util.Objects;

@Getter
public abstract class Character<T> extends Stat {

    protected int level;
    protected double attackSpeed;
    protected double evasionRate;
    protected Weapon weapon;

    protected Character(int hp, int mp, int attackDmg, int defenseDmg, int level, double attackSpeed, double evasionRate, Weapon weapon) {
        super(hp, mp, attackDmg, defenseDmg);
        this.level = level;
        this.attackSpeed = attackSpeed;
        this.evasionRate = evasionRate;
        mountWeapon(weapon);
    }

    public abstract T useSkill();

//    protected abstract T getThis();

    public void mountWeapon(Weapon mountWeapon){
        if (Objects.isNull(mountWeapon)) {
            this.weapon = new Hand();
        }else {
            this.weapon = mountWeapon;
        }
    }

//    public void levelUp(){
//        level += 1;
//    }
//
//    public void heal(){
//        this.hp += 100;
//    }
//
//    public void steam(){
//        this.attackDmg *= 1.2;
//    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getAttackDmg() {
        return weapon.calculateAttackDmg(attackDmg);
    }
    public double getAttackSpeed() {
        return decimalTwoFormat(weapon.calculateAttackSpeed(attackSpeed));
    }

    public double getEvasionRate() {
        return decimalTwoFormat(evasionRate);
    }

    public int getDefenseDmg() {
        return defenseDmg;
    }

    private double decimalTwoFormat(double value){
        String pattern = "#.##";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        return Double.parseDouble(decimalFormat.format(value));
    }
}
