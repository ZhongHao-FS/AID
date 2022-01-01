// Hao Zhong
// AID - 202110
// Administrator.java
package com.fullsail.aid.zhonghao_ce05;

import androidx.annotation.NonNull;

public class Administrator extends Person {

    private final String program;

    // Constructor
    public Administrator(String _firstName, String _lastName, String _program) {
        super(_firstName, _lastName);

        program = _program;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + " | " + program;
    }
}
