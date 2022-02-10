package com.study.oopkata.domain.character;


import com.study.oopkata.domain.character.weapon.Weapon;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Elf extends Character<Elf>{


    public Elf(@NonNull int level, Weapon weapon) {
        super(750*level, 700*level, 50*level, 30*level, level, 2, 0.25, weapon);
    }

    @Override
    public Elf useSkill() {
        return null;
    }

}
