package com.study.oopkata.domain.character.weapon.bow;

import com.study.oopkata.domain.character.Character;
import com.study.oopkata.domain.character.weapon.Weapon;

public class IronBow extends Weapon {

    public IronBow() {
        super("Iron Bow");
    }

    @Override
    public void mount(Character character) {
        character.plusAttackSpeed(1.1);
    }

    @Override
    public void dismount(Character character) {
        character.minusAttackSpeed(1.1);
    }

}
