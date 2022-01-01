// Hao Zhong
// AID - 202110
// Person.java
package com.fullsail.aid.zhonghao_ce05;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Person implements Serializable {
    private final String firstName;
    private final String lastName;

    // Constructor
    public Person(String _firstName, String _lastName) {
       firstName = _firstName;
       lastName = _lastName;
    }

    @NonNull
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
