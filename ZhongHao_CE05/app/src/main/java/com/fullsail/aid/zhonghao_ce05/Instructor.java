// Hao Zhong
// AID - 202110
// Instructor.java
package com.fullsail.aid.zhonghao_ce05;

import androidx.annotation.NonNull;

public class Instructor extends Person {

    private final String course;

    // Constructor
    public Instructor(String _firstName, String _lastName, String _course) {
        super(_firstName, _lastName);

        course = _course;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + " | " + course;
    }
}
