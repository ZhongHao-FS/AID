// Hao Zhong
// AID - 202110
// DetailsFragment.java
package com.fullsail.aid.zhonghao_ce07.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fullsail.aid.zhonghao_ce07.R;

public class DetailsFragment extends Fragment {

    private DeletePersonListener listener;

    public DetailsFragment() {
        super(R.layout.fragment_details);
    }

    public interface DeletePersonListener {
        void onDeletePerson();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof DeletePersonListener) {
            listener = (DeletePersonListener) context;
        }
    }

    public static DetailsFragment newInstance(Bundle person) {
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(person);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String fName = requireArguments().getString(getString(R.string.key_firstName));
        String lName = requireArguments().getString(getString(R.string.key_lastName));
        int age = requireArguments().getInt(getString(R.string.key_age));
        String profile = "First Name:\n" + fName + "\n\nLast Name:\n" + lName + "\n\nAge:\n" + age;

        TextView info = view.findViewById(R.id.textView);
        info.setText(profile);
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
            listener.onDeletePerson();
        }

        return super.onOptionsItemSelected(item);
    }
}
