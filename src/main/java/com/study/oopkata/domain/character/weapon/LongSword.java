package com.study.oopkata.domain.character.weapon;

import com.study.oopkata.domain.character.Character;

public class LongSword extends Weapon{

    public LongSword() {
        super("Long Sword");
    }

    @Override
    public void mount(Character character) {
        character.plusAttackDmg(1.1);

    }

    @Override
    public void dismount(Character character) {
        character.minusAttackDmg(1.1);
    }

}
