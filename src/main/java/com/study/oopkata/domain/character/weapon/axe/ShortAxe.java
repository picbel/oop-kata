package com.study.oopkata.domain.character.weapon.axe;

import com.study.oopkata.domain.character.Character;
import com.study.oopkata.domain.character.weapon.Weapon;

public class ShortAxe extends Weapon {

    public ShortAxe() {
        super("Short Axe");
    }

    @Override
    public void mount(Character character) {
        character.plusAttackDmg(1.1);
        character.minusAttackSpeed(1.05);
    }

    @Override
    public void dismount(Character character) {
        character.minusAttackDmg(1.1);
        character.plusAttackDmg(1.05);
    }
}
