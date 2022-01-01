// Hao Zhong
// AID - 202110
// FormActivity.java
package com.fullsail.aid.zhonghao_ce07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.fullsail.aid.zhonghao_ce07.fragments.FormFragment;

public class FormActivity extends AppCompatActivity implements FormFragment.ReturnPersonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        if (getIntent() != null) {
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.form_fragment_container, FormFragment.class, null).commit();
        }
    }

    @Override
    public void onReturnPerson(String fName, String lName, int age) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(getString(R.string.key_firstName), fName);
        returnIntent.putExtra(getString(R.string.key_lastName), lName);
        returnIntent.putExtra(getString(R.string.key_age), age);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}