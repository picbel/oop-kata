package com.study.oopkata.domain.character;


import com.study.oopkata.domain.Stat;
import com.study.oopkata.domain.character.skill.Skills;
import com.study.oopkata.domain.character.weapon.Hand;
import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.text.DecimalFormat;
import java.util.Objects;

@Log4j2
@Getter
public abstract class Characters extends Stat {

    protected double attackSpeed; // 1초당 공격횟수 ex 공격속도가 1일시 1초에 1대씩 공격 가능
    protected double evasionRate;
    protected Weapon weapon;
    protected Skills skill;
    protected boolean hitStatus = true;

    protected Characters(String race,int level, int hp, int mp, int attackDmg, int defenseDmg, double attackSpeed, double evasionRate, Weapon weapon, Skills skill) throws Exception {
        super(race, level,hp, mp, attackDmg, defenseDmg);
        this.attackSpeed = attackSpeed;
        this.evasionRate = evasionRate;
        this.skill = skill;
        mountWeapon(weapon);

    }

    public abstract void levelUp(int up);

    @Override
    public int getHp() {
        return hp;
    }
    @Override
    public int getMp() {
        return mp;
    }
    @Override
    public int getAttackDmg() {
        return weapon.calculateAttackDmg(attackDmg);
    }
    @Override
    public int getDefenseDmg() { return defenseDmg;}

    public boolean isUsedUltimate(){
        return level >= 99;
    }

    public void mountWeapon(Weapon mountWeapon) throws Exception {
        if (Objects.isNull(mountWeapon)) {
            this.weapon = new Hand();
        }else {
            boolean mountable = mountWeapon.isMountable(this);
            if (!mountable){ throw new Exception("해당 캐릭터에서 장착 할수 없는 무기입니다.");}

            this.weapon = mountWeapon;
        }
    }

    public void plusAttackDmg(int plus){
        this.attackDmg += plus;
    }
    public void multiplyAttackDmg(double plusPer){
        this.attackDmg *= plusPer;
    }
    public void divideAttackDmg(double minusPer){
        this.attackDmg /= minusPer;
    }

    public void plusDefenseDmg(int plus){ this.defenseDmg += plus; }
    public void multiplyDefenseDmg(double plusPer){
        this.defenseDmg *= plusPer;
    }
    public void divideDefenseDmg(double minusPer){
        this.defenseDmg /= minusPer;
    }
    
    public void multiplyEvasionRate(double plusPer){
        this.evasionRate *= plusPer;
    }
    public void divideEvasionRate(double plusPer){
        this.evasionRate /= plusPer;
    }

    public void multiplyAttackSpeed(double plusPer){
        this.attackSpeed *= plusPer;
    }
    public void divideAttackSpeed(double plusPer){
        this.attackSpeed /= plusPer;
    }

    public double getAttackSpeed() {
        return decimalTwoFormat(weapon.calculateAttackSpeed(attackSpeed));
    }
    public double getEvasionRate() {
        return decimalTwoFormat(evasionRate);
    }

    public void changeHitStatus(boolean status){
        this.hitStatus = status;
    }

    private double decimalTwoFormat(double value){
        String pattern = "#.##";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        return Double.parseDouble(decimalFormat.format(value));
    }



}
