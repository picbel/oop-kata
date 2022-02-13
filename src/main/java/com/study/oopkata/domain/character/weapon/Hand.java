package com.study.oopkata.domain.character.weapon;

import com.study.oopkata.domain.character.Characters;

public class Hand extends Weapon{
    public Hand() {
        super("Hand", 1, 1);
    }

    @Override
    public boolean isMountable(Characters characters) {
        return true;
    }
}
