// Hao Zhong
// AID - 202110
// Student.java
package com.fullsail.aid.zhonghao_ce05;

import androidx.annotation.NonNull;

public class Student extends Person {

    private final String idNumber;

    // Constructor
    public Student(String _firstName, String _lastName, String _idNumber) {
        super(_firstName, _lastName);

        idNumber = _idNumber;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + " | " + idNumber;
    }
}
