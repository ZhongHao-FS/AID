// Hao Zhong
// AID - 202110
// MainActivity.java
package com.fullsail.aid.zhonghao_ce08;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fullsail.aid.zhonghao_ce08.fragments.MonsterListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MonsterListFragment.MonsterClickListener {

    Context c;
    private final ArrayList<Monster> mMonsters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = this;
        FloatingActionButton mFloatingAB = findViewById(R.id.floatingActionButton);
        mFloatingAB.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .add(R.id.listFragmentContainerView, MonsterListFragment.newInstance(mMonsters)).commit();
    }

    @Override
    public void onClick(View view) {
        Intent explicitForm = new Intent(c, FormActivity.class);
        mFormLauncher.launch(explicitForm);
    }

    ActivityResultLauncher<Intent> mFormLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData().hasExtra(getString(R.string.key_saveMonster))) {
                        Monster newMon = (Monster) result.getData().getSerializableExtra(getString(R.string.key_saveMonster));
                        mMonsters.add(newMon);
                        refreshList();
                    }
                }
            }
    );

    private void refreshList() {
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.listFragmentContainerView, MonsterListFragment.newInstance(mMonsters)).commit();
    }

    @Override
    public void onMonsterClicked(int index) {
        Intent explicitDetails = new Intent(c, DetailsActivity.class);
        explicitDetails.putExtra(getString(R.string.key_detailsMonster), mMonsters.get(index));
        mDetailsLauncher.launch(explicitDetails);
    }

    ActivityResultLauncher<Intent> mDetailsLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData().hasExtra(getString(R.string.key_deleteMonster))) {
                        Monster deMon = (Monster) result.getData().getSerializableExtra(getString(R.string.key_deleteMonster));
                        for (int i = 0; i < mMonsters.size(); i++) {
                            if (mMonsters.get(i).toString().equals(deMon.toString())) {
                                mMonsters.remove(i);
                                break;
                            }
                        }
                        refreshList();
                    }
                }
            }
    );
}