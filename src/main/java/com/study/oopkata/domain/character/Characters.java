package com.study.oopkata.domain.character;


import com.study.oopkata.domain.Stat;
import com.study.oopkata.domain.character.skill.Skills;
import com.study.oopkata.domain.character.weapon.Hand;
import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;

import java.text.DecimalFormat;
import java.util.Objects;

@Getter
public abstract class Characters extends Stat {

    protected double attackSpeed;
    protected double evasionRate;
    protected Weapon weapon;
    protected Skills skill;
    protected boolean hitStatus = true;

    protected Characters(int level, int hp, int mp, int attackDmg, int defenseDmg, double attackSpeed, double evasionRate, Weapon weapon, Skills skill) throws Exception {
        //Todo 0레벨 검사하기 AOP로 !
        super(level,hp, mp, attackDmg, defenseDmg);
        this.attackSpeed = attackSpeed;
        this.evasionRate = evasionRate;
        this.skill = skill;
        mountWeapon(weapon);

    }

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

    public boolean isDie(){
        return hp <= 0;
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

//    public void levelUp(){
//        level += 1;
//    }

    public void plusHp(int plus){
        this.hp += plus;
    }
    public void minusMp(int useMp){
        this.mp -= useMp;
    }

    public void multiplyAttackDmg(double plusPer){
        this.attackDmg *= plusPer;
    }
    public void divideAttackDmg(double minusPer){
        this.attackDmg /= minusPer;
    }

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
