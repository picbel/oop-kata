package com.study.oopkata.domain.character;

import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Human extends Character<Human>{

    public Human(@NonNull int level, Weapon weapon) {
        super(1000*level, 500*level, 100*level, 50*level, level, 1.0, 0.1, weapon);
    }

    @Override
    public Human useSkill() {
        return this;
    }
}
