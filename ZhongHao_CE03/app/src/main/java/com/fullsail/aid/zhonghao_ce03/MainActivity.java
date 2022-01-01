// Hao Zhong
// AID - 202110
// MainActivity.java
package com.fullsail.aid.zhonghao_ce03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    private FrameLayout mFrame;
    private TextView mTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrame = findViewById(R.id.frame);
        mTarget = findViewById(R.id.textView_target);

        RadioGroup bgdColorGroup = (RadioGroup) findViewById(R.id.radiogroup1);
        bgdColorGroup.setOnCheckedChangeListener(this);

        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(textWatcher);

        RadioGroup txtColorGroup = (RadioGroup) findViewById(R.id.radiogroup2);
        txtColorGroup.setOnCheckedChangeListener(this);

        SwitchCompat boldControl = (SwitchCompat) findViewById(R.id.switch1);
        boldControl.setOnCheckedChangeListener(this);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void afterTextChanged(Editable editable) {
            mTarget.setText(editable);
        }
    };

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.getId() == R.id.radiogroup1) {
            switch (i) {
                case R.id.radioButton_bc1:
                    mFrame.setBackgroundColor(getColor(R.color.purple_200));
                    break;
                case R.id.radioButton_bc2:
                    mFrame.setBackgroundColor(getColor(R.color.teal_200));
                    break;
                case R.id.radioButton_bc3:
                    mFrame.setBackgroundColor(getColor(R.color.black));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
        } else if (radioGroup.getId() == R.id.radiogroup2) {
            switch (i) {
                case R.id.radioButton_tc1:
                    mTarget.setTextColor(getColor(R.color.purple_200));
                    break;
                case R.id.radioButton_tc2:
                    mTarget.setTextColor(getColor(R.color.teal_200));
                    break;
                case R.id.radioButton_tc3:
                    mTarget.setTextColor(getColor(R.color.black));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            mTarget.setTextAppearance(R.style.boldStyle);
        } else {
            mTarget.setTextAppearance(R.style.Theme_ZhongHao_CE03);
        }
    }
}