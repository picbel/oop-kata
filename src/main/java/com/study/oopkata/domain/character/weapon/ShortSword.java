package com.study.oopkata.domain.character.weapon;

import com.study.oopkata.domain.character.Character;

public class ShortSword extends Weapon{

    public ShortSword() {
        super("Short Sword");
    }

    @Override
    public void mount(Character character) {
        character.plusAttackDmg(1.05);

    }

    @Override
    public void dismount(Character character) {
        character.minusAttackDmg(1.05);
    }

}
