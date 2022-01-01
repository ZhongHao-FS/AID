// Hao Zhong
// AID - 202110
// DetailsActivity.java
package com.fullsail.aid.zhonghao_ce07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.fullsail.aid.zhonghao_ce07.fragments.DetailsFragment;

public class DetailsActivity extends AppCompatActivity implements DetailsFragment.DeletePersonListener {

    private Bundle mPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getIntent() != null) {
            mPerson = getIntent().getExtras();

            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.details_fragment_container, DetailsFragment.newInstance(mPerson)).commit();
        }
    }

    @Override
    public void onDeletePerson() {
        Intent returnIntent = new Intent();
        returnIntent.putExtras(mPerson);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}