package com.study.oopkata.usecase;

public interface Behavior {

    void attack();

    boolean attackDelay();

    void hit();

    boolean evasionAttack();

    // 공격 회피 등 캐릭터와 몬스터를 조합하는 시스템은 Behavior 구현체에서 구현
    // 배틀 시뮬레이터는 두개를 반복실행하는 시뮬레이터의 역할
}
