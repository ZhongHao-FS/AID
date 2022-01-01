// Hao Zhong
// AID - 202110
// Contact.java
package com.fullsail.aid.zhonghao_ce06;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Contact implements Serializable {
    private final String firstName;
    private final String lastName;
    private final long number;

    // Constructor
    public Contact(String _firstName, String _lastName, long _number) {
        firstName = _firstName;
        lastName = _lastName;
        number = _number;
    }

    @NonNull
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
