// Hao Zhong
// AID - 202110
// FormFragment.java
package com.fullsail.aid.zhonghao_ce06.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fullsail.aid.zhonghao_ce06.Contact;
import com.fullsail.aid.zhonghao_ce06.R;

import java.util.Objects;

public class FormFragment extends Fragment implements View.OnClickListener {

    private EditText mFNameET;
    private EditText mLNameET;
    private EditText mPhoneET;
    private Button mAddButton;
    private AddListener mAddListener;

    public FormFragment() {super(R.layout.form_fragment);}

    public interface AddListener{
        void onAddListener(Contact contact);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof AddListener) {
            mAddListener = (AddListener) context;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFNameET = view.findViewById(R.id.editText_firstName);
        mFNameET.addTextChangedListener(textWatcher);
        mLNameET = view.findViewById(R.id.editText_lastName);
        mLNameET.addTextChangedListener(textWatcher);
        mPhoneET = view.findViewById(R.id.editTextPhone);
        mPhoneET.addTextChangedListener(textWatcher);

        mAddButton = view.findViewById(R.id.addButton);
        mAddButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (getView() != null) {

            String firstName = mFNameET.getText().toString();
            String lastName = mLNameET.getText().toString();
            long number = Long.parseLong(mPhoneET.getText().toString());

            mAddListener.onAddListener(new Contact(firstName, lastName, number));

            mFNameET.getText().clear();
            mLNameET.getText().clear();
            mPhoneET.getText().clear();
        }
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void afterTextChanged(Editable editable) { validateInput(); }
    };

    private void validateInput() {
        String firstInput = mFNameET.getText().toString();
        String lastInput = mLNameET.getText().toString();
        String numberInput = mPhoneET.getText().toString();

        mAddButton.setEnabled(isNotNullOrEmpty(firstInput) && isNotNullOrEmpty(lastInput) && isNotNullOrEmpty(numberInput) && isLong(numberInput));
    }

    private boolean isNotNullOrEmpty(String _text) {
        return !Objects.equals(_text, null) && !_text.trim().isEmpty();
    }

    private boolean isLong(String _string) {
        try {
            Long.parseLong(_string);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
