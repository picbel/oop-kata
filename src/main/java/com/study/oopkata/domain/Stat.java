package com.study.oopkata.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Stat {

    protected int hp;
    protected int mp;
    protected int attackDmg;
    protected int defenseDmg;


}
