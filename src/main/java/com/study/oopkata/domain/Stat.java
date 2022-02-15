package com.study.oopkata.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Stat {

    protected int level;
    protected int hp;
    protected int mp;
    protected int attackDmg;
    protected int defenseDmg;

    public void plusHp(int plus){
        this.hp += plus;
    }
    public void minusHp(int minus) {this.hp -= minus;}
    public void minusMp(int useMp){
        this.mp -= useMp;
    }

}
