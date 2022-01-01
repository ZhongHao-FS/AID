// Hao Zhong
// AID - 202110
// MonsterListFragment.java
package com.fullsail.aid.zhonghao_ce08.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.fullsail.aid.zhonghao_ce08.Monster;
import com.fullsail.aid.zhonghao_ce08.R;

import java.util.ArrayList;

public class MonsterListFragment extends ListFragment {

    private static final String TAG = "MonsterListFragment.TAG";
    private MonsterClickListener listener;

    public interface MonsterClickListener {
        void onMonsterClicked(int index);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof MonsterClickListener) {
            listener = (MonsterClickListener) context;
        }
    }

    public static MonsterListFragment newInstance(ArrayList<Monster> _monsters) {

        Bundle args = new Bundle();
        args.putSerializable(TAG, _monsters);

        MonsterListFragment fragment = new MonsterListFragment();
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

        ArrayList<Monster> monsters = (ArrayList<Monster>) requireArguments().getSerializable(TAG);
        ArrayAdapter<Monster> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                monsters
        );
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        listener.onMonsterClicked(position);
    }
}
