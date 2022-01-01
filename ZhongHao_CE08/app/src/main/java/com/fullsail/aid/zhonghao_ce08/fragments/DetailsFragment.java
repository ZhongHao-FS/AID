// Hao Zhong
// AID - 202110
// DetailsFragment.java
package com.fullsail.aid.zhonghao_ce08.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fullsail.aid.zhonghao_ce08.Monster;
import com.fullsail.aid.zhonghao_ce08.R;

public class DetailsFragment extends Fragment {

    private static final String TAG = "DETAILS_KEY.TAG";
    private DeleteMonsterListener listener;
    private Monster mMonster;

    public DetailsFragment() {
        super(R.layout.details_fragment);
    }

    public interface DeleteMonsterListener {
        void onDeleteMonster();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof DeleteMonsterListener) {
            listener = (DeleteMonsterListener) context;
        }
    }

    public static DetailsFragment newInstance(Monster monster) {
        Bundle args = new Bundle();
        args.putSerializable(TAG, monster);

        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMonster = (Monster) requireArguments().getSerializable(TAG);

        TextView info = view.findViewById(R.id.textView);
        info.setText(mMonster.toString());
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_details, menu);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete) {
            listener.onDeleteMonster();
        }

        if (item.getItemId() == R.id.share) {
            Intent impIntent = new Intent(Intent.ACTION_SEND);
            impIntent.putExtra(Intent.EXTRA_TEXT, mMonster.toString());
            impIntent.setType("text/plain");
            startActivity(impIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
