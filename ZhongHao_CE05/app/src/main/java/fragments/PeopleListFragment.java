// Hao Zhong
// AID - 202110
// PeopleListFragment.java
package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.fullsail.aid.zhonghao_ce05.Administrator;
import com.fullsail.aid.zhonghao_ce05.Instructor;
import com.fullsail.aid.zhonghao_ce05.Person;
import com.fullsail.aid.zhonghao_ce05.R;
import com.fullsail.aid.zhonghao_ce05.Student;

import java.util.ArrayList;

public class PeopleListFragment extends ListFragment {

    private static final String ARG_PEOPLE = "ARG_PEOPLE";

    // Default Constructor
    public PeopleListFragment() { }

    public static PeopleListFragment newInstance(ArrayList<Person> people) {

        Bundle args = new Bundle();
        ArrayList<String> peopleStrings = new ArrayList<>();

        for (Person person: people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                peopleStrings.add(student.toString());
            } else if (person instanceof Instructor) {
                Instructor instructor = (Instructor) person;
                peopleStrings.add(instructor.toString());
            } else if (person instanceof Administrator) {
                Administrator administrator = (Administrator) person;
                peopleStrings.add(administrator.toString());
            }
        }

        args.putStringArrayList(ARG_PEOPLE, peopleStrings);

        PeopleListFragment fragment = new PeopleListFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> peopleStrings = requireArguments().getStringArrayList(ARG_PEOPLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                peopleStrings
        );
        setListAdapter(adapter);
    }
}
