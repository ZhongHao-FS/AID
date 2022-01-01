// Hao Zhong
// AID - 202110
// AdminFormFragment.java
package fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fullsail.aid.zhonghao_ce05.Administrator;
import com.fullsail.aid.zhonghao_ce05.R;

public class AdminFormFragment extends Fragment implements View.OnClickListener {

    private AddAdminListener mAddListener;

    public AdminFormFragment() {
        super(R.layout.fragment_form_administrator);
    }

    public interface AddAdminListener {
        void onAddAdminListener(Administrator administrator);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button add = view.findViewById(R.id.button_addAdmin);
        add.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof AddAdminListener) {
            mAddListener = (AddAdminListener) context;
        }
    }

    @Override
    public void onClick(View view) {
        if (getView() != null) {
            EditText fNameET = getView().findViewById(R.id.editText_admin_firstName);
            String firstName = fNameET.getText().toString();
            EditText lNameET = getView().findViewById(R.id.editText_admin_lastName);
            String lastName = lNameET.getText().toString();
            EditText programET = getView().findViewById(R.id.editText_admin_program);
            String program = programET.getText().toString();

            mAddListener.onAddAdminListener(new Administrator(firstName, lastName, program));

            fNameET.getText().clear();
            lNameET.getText().clear();
            programET.getText().clear();
        }
    }
}
