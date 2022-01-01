// Hao Zhong
// AID - 202110
// ContactListFragment.java
package com.fullsail.aid.zhonghao_ce06.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.fullsail.aid.zhonghao_ce06.Contact;
import com.fullsail.aid.zhonghao_ce06.R;

import java.util.ArrayList;

public class ContactListFragment extends ListFragment {

    private static final String TAG = "ContactListFragment.TAG";

    
    public static ContactListFragment newInstance(ArrayList<Contact> _contacts) {

        Bundle args = new Bundle();
        args.putSerializable(TAG, _contacts);

        ContactListFragment fragment = new ContactListFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Contact> contacts = (ArrayList<Contact>) requireArguments().getSerializable(TAG);
        ArrayAdapter<Contact> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                contacts
        );
        setListAdapter(adapter);
    }
}
