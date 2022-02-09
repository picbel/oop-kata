package com.study.oopkata.character.model;

import com.study.oopkata.character.domain.Character;

public enum Weapon {
    ShortSword{};

    public void mount(Character character) {
        character.changeProperty();
    }


}
