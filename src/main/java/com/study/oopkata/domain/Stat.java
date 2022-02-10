package com.study.oopkata.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Stat {

    protected int hp;
    protected int mp;
    protected int attackDmg;
    protected int defenseDmg;


}
