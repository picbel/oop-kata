package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Orc extends Character<Orc>{

    public Orc(@NonNull int level, Weapon weapon) {
        super(1200*level, 300*level, 120*level, 30*level, level, 0.7, 0, weapon);
    }

    @Override
    public Orc useSkill() {
        return null;
    }

    @Override
    protected Orc getThis() {
        return this;
    }
}
