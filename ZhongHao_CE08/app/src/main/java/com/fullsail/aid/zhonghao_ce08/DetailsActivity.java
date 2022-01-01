// Hao Zhong
// AID - 202110
// DetailsActivity.java
package com.fullsail.aid.zhonghao_ce08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.fullsail.aid.zhonghao_ce08.fragments.DetailsFragment;

public class DetailsActivity extends AppCompatActivity implements DetailsFragment.DeleteMonsterListener {

    private Monster mMonster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTheme(R.style.Theme_ZhongHao_CE08Night);

        if (getIntent() != null) {
            mMonster = (Monster) getIntent().getSerializableExtra(getString(R.string.key_detailsMonster));

            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.details_fragment_container, DetailsFragment.newInstance(mMonster)).commit();
        }
    }

    @Override
    public void onDeleteMonster() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(getString(R.string.key_deleteMonster), mMonster);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}