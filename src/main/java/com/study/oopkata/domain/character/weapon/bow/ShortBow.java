package com.study.oopkata.domain.character.weapon.bow;

import com.study.oopkata.domain.character.Character;
import com.study.oopkata.domain.character.weapon.Weapon;

public class ShortBow extends Weapon {
    public ShortBow() {
        super("Short Bow");
    }

    @Override
    public void mount(Character character) {
        character.plusAttackSpeed(1.05);
    }

    @Override
    public void dismount(Character character) {
        character.minusAttackSpeed(1.05);
    }

}
