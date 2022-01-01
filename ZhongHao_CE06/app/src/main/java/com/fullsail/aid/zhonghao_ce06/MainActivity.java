// Hao Zhong
// AID - 202110
// MainActivity.java
package com.fullsail.aid.zhonghao_ce06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.fullsail.aid.zhonghao_ce06.fragments.ContactListFragment;
import com.fullsail.aid.zhonghao_ce06.fragments.FormFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FormFragment.AddListener {

    private final ArrayList<Contact> mContacts = new ArrayList<>();
    private FloatingActionButton mFloatingAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFloatingAB = findViewById(R.id.floatingActionButton);
        mFloatingAB.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .add(R.id.fragmentContainerView, ContactListFragment.newInstance(mContacts)).commit();

        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            int backStackCount = getSupportFragmentManager().getBackStackEntryCount();

            if (backStackCount > 0) {
                mFloatingAB.hide();
            } else {
                mFloatingAB.show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_left, R.anim.slide_out_right)
                .setReorderingAllowed(true).addToBackStack("Form").replace(R.id.fragmentContainerView, FormFragment.class, null).commit();

    }

    @Override
    public void onAddListener(Contact contact) {
        mContacts.add(contact);

        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_left, R.anim.slide_out_right)
                .setReorderingAllowed(true).replace(R.id.fragmentContainerView, ContactListFragment.newInstance(mContacts)).commit();
    }
}