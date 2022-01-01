// Hao Zhong
// AID - 202110
// Monster.java
package com.fullsail.aid.zhonghao_ce08;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Monster implements Serializable {
    private final String name;
    private final boolean fur;
    private final int legs;

    // Constructor
    public Monster(String _name, boolean _fur, int _legs) {
        name = _name;
        fur = _fur;
        legs = _legs;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name of Monster\n" + name + '\n' +
                "\nMonster has fur\n" + fur +
                "\n\nNumber of legs\n" + legs;
    }
}
