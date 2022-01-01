// Hao Zhong
// AID - 202110
// InstructorFormFragment.java
package fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fullsail.aid.zhonghao_ce05.Instructor;
import com.fullsail.aid.zhonghao_ce05.R;

public class InstructorFormFragment extends Fragment implements View.OnClickListener {

    private AddInstructorListener mAddListener;

    public InstructorFormFragment() {
        super(R.layout.fragment_form_instructor);
    }

    public interface AddInstructorListener {
        void onAddInstructorListener(Instructor instructor);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button add = view.findViewById(R.id.button_addInstructor);
        add.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof AddInstructorListener) {
            mAddListener = (AddInstructorListener) context;
        }
    }

    @Override
    public void onClick(View view) {
        if (getView() != null) {
            EditText fNameET = getView().findViewById(R.id.editText_instructor_firstName);
            String firstName = fNameET.getText().toString();
            EditText lNameET = getView().findViewById(R.id.editText_instructor_lastName);
            String lastName = lNameET.getText().toString();
            EditText courseET = getView().findViewById(R.id.editText_instructor_course);
            String course = courseET.getText().toString();

            mAddListener.onAddInstructorListener(new Instructor(firstName, lastName, course));

            fNameET.getText().clear();
            lNameET.getText().clear();
            courseET.getText().clear();
        }
    }
}
