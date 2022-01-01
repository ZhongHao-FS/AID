// Hao Zhong
// AID - 202110
// MainActivity.java
package com.fullsail.aid.zhonghao_ce05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import fragments.AdminFormFragment;
import fragments.InstructorFormFragment;
import fragments.PeopleListFragment;
import fragments.StudentFormFragment;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, StudentFormFragment.AddStudentListener, InstructorFormFragment.AddInstructorListener, AdminFormFragment.AddAdminListener {

    private final ArrayList<Person> mPeople = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            Spinner spinner = findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinner, R.layout.support_simple_spinner_dropdown_item);
            spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerAdapter);
            spinner.setOnItemSelectedListener(this);

            Button refresh = findViewById(R.id.button);
            refresh.setOnClickListener(this);

            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.fragmentContainerView, PeopleListFragment.newInstance(mPeople)).commit();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selection = (String) adapterView.getItemAtPosition(i);
        showFormFragment(selection);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        showFormFragment("Student");
    }

    private void showFormFragment(String _selection) {
        switch (_selection) {
            case "Student":
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.formFragmentContainerView, StudentFormFragment.class, null).commit();
                break;
            case "Instructor":
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.formFragmentContainerView, InstructorFormFragment.class, null).commit();
                break;
            case "Administrator":
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.formFragmentContainerView, AdminFormFragment.class, null).commit();
                break;
        }

    }

    @Override
    public void onClick(View view) {
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.fragmentContainerView, PeopleListFragment.newInstance(mPeople)).commit();
    }

    @Override
    public void onAddStudentListener(Student student) {
        mPeople.add(student);
    }

    @Override
    public void onAddInstructorListener(Instructor instructor) {
        mPeople.add(instructor);
    }

    @Override
    public void onAddAdminListener(Administrator administrator) {
        mPeople.add(administrator);
    }
}