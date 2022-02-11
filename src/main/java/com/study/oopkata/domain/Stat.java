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


}
