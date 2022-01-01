// Hao Zhong
// AID - 202110
// FormFragment.java
package com.fullsail.aid.zhonghao_ce07.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fullsail.aid.zhonghao_ce07.R;

public class FormFragment extends Fragment {

    private ReturnPersonListener listener;

    EditText editFirstName;
    EditText editLastName;
    EditText editAge;

    public FormFragment() {
        super(R.layout.fragment_form);
    }

    public interface ReturnPersonListener {
        void onReturnPerson(String fName, String lName, int age);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ReturnPersonListener) {
            listener = (ReturnPersonListener) context;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editFirstName = view.findViewById(R.id.editText_firstName);
        editLastName = view.findViewById(R.id.editText_lastName);
        editAge = view.findViewById(R.id.editTextNumber);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_form, menu);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save && validateInput()) {
            String fName = editFirstName.getText().toString();
            String lName = editLastName.getText().toString();
            int age = Integer.parseInt(editAge.getText().toString());

            listener.onReturnPerson(fName, lName, age);
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean validateInput() {
        String fName = editFirstName.getText().toString();
        if (fName.trim().isEmpty()) {
            Toast.makeText(getContext(), R.string.warning_fName, Toast.LENGTH_SHORT).show();
            return false;
        }

        String lName = editLastName.getText().toString();
        if (lName.trim().isEmpty()) {
            Toast.makeText(getContext(), R.string.warning_lName, Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            int age = Integer.parseInt(editAge.getText().toString());
            if (age <= 0) {
                Toast.makeText(getContext(), R.string.warning_age_tooSmall, Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (NumberFormatException exception) {
            Toast.makeText(getContext(), R.string.warning_age, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
