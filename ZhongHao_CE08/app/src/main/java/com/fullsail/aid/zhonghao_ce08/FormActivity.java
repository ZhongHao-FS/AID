// Hao Zhong
// AID - 202110
// FormActivity.java
package com.fullsail.aid.zhonghao_ce08;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fullsail.aid.zhonghao_ce08.fragments.FormFragment;

public class FormActivity extends AppCompatActivity implements FormFragment.ReturnMonsterListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        if (getIntent() != null) {
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.form_fragment_container, FormFragment.class, null).commit();
        }
    }

    @Override
    public void onReturnMonster(Monster monster) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(getString(R.string.key_saveMonster), monster);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
