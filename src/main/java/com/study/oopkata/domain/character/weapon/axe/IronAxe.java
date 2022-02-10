package com.study.oopkata.domain.character.weapon.axe;

import com.study.oopkata.domain.character.Character;
import com.study.oopkata.domain.character.weapon.Weapon;

public class IronAxe extends Weapon {

    public IronAxe() {
        super("Iron Axe");
    }

    @Override
    public void mount(Character character) {
        character.plusAttackDmg(1.2);
        character.minusAttackSpeed(1.1);
    }

    @Override
    public void dismount(Character character) {
        character.minusAttackDmg(1.2);
        character.plusAttackDmg(1.1);
    }

}
