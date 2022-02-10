package com.study.oopkata.domain.character;


import com.study.oopkata.domain.Stat;
import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class Character extends Stat {

    protected int level;
    protected double attackSpeed;
    protected double evasionRate;

    protected Weapon weapon;

    public void mountWeapon(Weapon mountWeapon){
        if (Objects.nonNull(this.weapon)) {
            this.weapon.dismount(this);
        }
        mountWeapon.mount(this);
    }

    public void plusAttackDmg(double per){
        this.attackDmg*=per;
    }

    public void minusAttackDmg(double per){
        this.attackDmg/=per;
    }

    public void plusAttackSpeed(double per){
        attackSpeed*=per;
    }

    public void minusAttackSpeed(double per){
        attackSpeed/=per;
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
