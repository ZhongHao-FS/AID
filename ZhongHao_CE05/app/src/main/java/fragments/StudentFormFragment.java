// Hao Zhong
// AID - 202110
// StudentFormFragment.java
package fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fullsail.aid.zhonghao_ce05.R;
import com.fullsail.aid.zhonghao_ce05.Student;

public class StudentFormFragment extends Fragment implements View.OnClickListener {

    private AddStudentListener mAddListener;

    public StudentFormFragment() {
        super(R.layout.fragment_form_student);
    }

    public interface AddStudentListener{
        void onAddStudentListener(Student student);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button add = view.findViewById(R.id.button_addStudent);
        add.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof AddStudentListener) {
            mAddListener = (AddStudentListener) context;
        }
    }

    @Override
    public void onClick(View view) {
        if (getView() != null) {
            EditText fNameET = getView().findViewById(R.id.editText_student_firstName);
            String firstName = fNameET.getText().toString();
            EditText lNameET = getView().findViewById(R.id.editText_student_lastName);
            String lastName = lNameET.getText().toString();
            EditText idNumET = getView().findViewById(R.id.editText_student_idNum);
            String idNumber = idNumET.getText().toString();

            mAddListener.onAddStudentListener(new Student(firstName, lastName, idNumber));

            fNameET.getText().clear();
            lNameET.getText().clear();
            idNumET.getText().clear();
        }
    }
}
