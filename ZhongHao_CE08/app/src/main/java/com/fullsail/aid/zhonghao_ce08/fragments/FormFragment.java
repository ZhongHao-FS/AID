// Hao Zhong
// AID - 202110
// FormFragment.java
package com.fullsail.aid.zhonghao_ce08.fragments;

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

import com.fullsail.aid.zhonghao_ce08.Monster;
import com.fullsail.aid.zhonghao_ce08.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class FormFragment extends Fragment {

    private ReturnMonsterListener listener;

    EditText editName;
    SwitchMaterial switchFur;
    EditText editLegs;

    public FormFragment() { super(R.layout.form_fragment);}

    public interface ReturnMonsterListener {
        void onReturnMonster(Monster monster);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ReturnMonsterListener) {
            listener = (ReturnMonsterListener) context;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editName = view.findViewById(R.id.editText_name);
        switchFur = view.findViewById(R.id.switch1);
        editLegs = view.findViewById(R.id.editTextNumber);
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
            String name = editName.getText().toString();
            boolean fur = switchFur.isChecked();
            int legs = Integer.parseInt(editLegs.getText().toString());

            listener.onReturnMonster(new Monster(name, fur, legs));
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean validateInput() {
        String name = editName.getText().toString();
        if (name.trim().isEmpty()) {
            Toast.makeText(getContext(), R.string.warning_name, Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            int legs = Integer.parseInt(editLegs.getText().toString());
            if (legs <= 0) {
                Toast.makeText(getContext(), R.string.warning_num_tooSmall, Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (NumberFormatException exception) {
            Toast.makeText(getContext(), R.string.warning_num, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
