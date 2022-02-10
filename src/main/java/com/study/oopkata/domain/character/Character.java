package com.study.oopkata.domain.character;


import com.study.oopkata.domain.Stat;
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
        this.weapon = weapon;
    }

    public abstract T useSkill();

    public double getAttackSpeed() {
        return decimalTwoFormat(attackSpeed);
    }
    protected double decimalTwoFormat(double value){
        String pattern = "#.##";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        return Double.parseDouble(decimalFormat.format(value));
    }
    protected abstract T getThis();

    public void mountWeapon(Weapon mountWeapon){
        if (Objects.isNull(mountWeapon)) {return;}

        if (Objects.nonNull(this.weapon)) {
            this.weapon.dismount(this);
        }
        mountWeapon.mount(this);
        this.weapon = mountWeapon;
    }



    public T plusAttackDmg(double per){
        this.attackDmg*=per;
        return getThis();
    }

    public T minusAttackDmg(double per){
        this.attackDmg/=per;
        return getThis();
    }

    public T plusAttackSpeed(double per){
        attackSpeed*=per;
        return getThis();
    }

    public T minusAttackSpeed(double per){
        attackSpeed/=per;
        return getThis();
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


}
