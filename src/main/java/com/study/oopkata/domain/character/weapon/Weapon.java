package com.study.oopkata.domain.character.weapon;

import com.study.oopkata.domain.character.Character;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Weapon {
    protected String name;

    public abstract void mount(Character character);

    public abstract void dismount(Character character);


}
